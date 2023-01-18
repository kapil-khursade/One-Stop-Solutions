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
public class GlobalExceptionHandler {

	// exception handler for operator

	@ExceptionHandler(OperatorException.class)
	public ResponseEntity<MyErrorBean> operatorExceptionHandler(OperatorException oe, WebRequest req) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(oe.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorBean>(err, HttpStatus.BAD_REQUEST);

	}

	// exception handler for solution

	@ExceptionHandler(SolutionException.class)
	public ResponseEntity<MyErrorBean> solutionExceptionHandler(SolutionException se, WebRequest req) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorBean>(err, HttpStatus.BAD_REQUEST);

	}

	// generic exception handler

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorBean> genericExceptionHandler(Exception e, WebRequest req) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorBean>(err, HttpStatus.BAD_REQUEST);

	}

	// if no exception handler is found

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorBean> myExceptionHandler(NoHandlerFoundException nhfe, WebRequest req) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(nhfe.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorBean>(err, HttpStatus.BAD_REQUEST);

	}

	// if method argument is not valid

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorBean> myMANVExceptionHandler(MethodArgumentNotValidException manve) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(manve.getBindingResult().getFieldError().getDefaultMessage());
		err.setDetails("Validation error");

		return new ResponseEntity<MyErrorBean>(err, HttpStatus.BAD_REQUEST);

	}
}
