package com.oneStopSolutions.operator.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalOperatorExceptionHandler {

	// exception handler for operator

	@ExceptionHandler(OperatorException.class)
	public ResponseEntity<MyOperatorErrorBean> operatorExceptionHandler(OperatorException oe, WebRequest req) {

		MyOperatorErrorBean err = new MyOperatorErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(oe.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyOperatorErrorBean>(err, HttpStatus.BAD_REQUEST);

	}

	// exception handler for solution

	@ExceptionHandler(SolutionException.class)
	public ResponseEntity<MyOperatorErrorBean> solutionExceptionHandler(SolutionException se, WebRequest req) {

		MyOperatorErrorBean err = new MyOperatorErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyOperatorErrorBean>(err, HttpStatus.BAD_REQUEST);

	}

	// generic exception handler

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyOperatorErrorBean> genericExceptionHandler(Exception e, WebRequest req) {

		MyOperatorErrorBean err = new MyOperatorErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyOperatorErrorBean>(err, HttpStatus.BAD_REQUEST);

	}

	// if no exception handler is found

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyOperatorErrorBean> myExceptionHandler(NoHandlerFoundException nhfe, WebRequest req) {

		MyOperatorErrorBean err = new MyOperatorErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(nhfe.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyOperatorErrorBean>(err, HttpStatus.BAD_REQUEST);

	}

	// if method argument is not valid

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyOperatorErrorBean> myMANVExceptionHandler(MethodArgumentNotValidException manve) {

		MyOperatorErrorBean err = new MyOperatorErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(manve.getBindingResult().getFieldError().getDefaultMessage());
		err.setDetails("Validation error");

		return new ResponseEntity<MyOperatorErrorBean>(err, HttpStatus.BAD_REQUEST);

	}
}
