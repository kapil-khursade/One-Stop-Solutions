package com.oneStopSolution.Admin.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice // AOP Aspect Oriented Programming
public class GlobalExceptionHandler {

	//Handler for Admin Exception

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorBean> studentExceptionHandler1(AdminException ae, WebRequest req) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	//Handler for Employee Exception

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyErrorBean> studentExceptionHandler2(EmployeeException ae, WebRequest req) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	//Handler for Employee Exception

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyErrorBean> studentExceptionHandler3(DepartmentException ae, WebRequest req) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	// Handler for any other Exception

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorBean> genericExceptionHandler4(Exception ae, WebRequest req) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	// No Handler Found Exception

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorBean> myexpHandler5(NoHandlerFoundException ae, WebRequest req) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	//Handler for Method Argument not valid Exception

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorBean> myMANVExceptionHandler6(MethodArgumentNotValidException me) {

		MyErrorBean err = new MyErrorBean();

		err.setTimestamp(LocalDateTime.now());
		err.setDetails("Validation Error");
		err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

}
