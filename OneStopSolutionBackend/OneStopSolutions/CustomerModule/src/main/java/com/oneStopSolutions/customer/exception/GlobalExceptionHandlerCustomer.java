package com.oneStopSolutions.customer.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandlerCustomer {
	
	// exception handler for customer
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetailsCustomer> customerExceptionHandler(CustomerException ce, WebRequest req) {

		MyErrorDetailsCustomer err = new MyErrorDetailsCustomer();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetailsCustomer>(err, HttpStatus.BAD_REQUEST);

	}
	
	// exception handler for issue
	
	@ExceptionHandler(IssueException.class)
	public ResponseEntity<MyErrorDetailsCustomer> issueExceptionHandler(IssueException ie, WebRequest req) {

		MyErrorDetailsCustomer err = new MyErrorDetailsCustomer();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetailsCustomer>(err, HttpStatus.BAD_REQUEST);

	}
	
	// exception handler for login
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetailsCustomer> loginExceptionHandler(LoginException le, WebRequest req) {

		MyErrorDetailsCustomer err = new MyErrorDetailsCustomer();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(le.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetailsCustomer>(err, HttpStatus.BAD_REQUEST);

	}
	
	// generic exception handler

		@ExceptionHandler(Exception.class)
		public ResponseEntity<MyErrorDetailsCustomer> genericExceptionHandler(Exception e, WebRequest req) {

			MyErrorDetailsCustomer err = new MyErrorDetailsCustomer();

			err.setTimestamp(LocalDateTime.now());
			err.setMessage(e.getMessage());
			err.setDetails(req.getDescription(false));

			return new ResponseEntity<MyErrorDetailsCustomer>(err, HttpStatus.BAD_REQUEST);

		}

		// if no exception handler is found

		@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<MyErrorDetailsCustomer> myExceptionHandler(NoHandlerFoundException nhfe, WebRequest req) {

			MyErrorDetailsCustomer err = new MyErrorDetailsCustomer();

			err.setTimestamp(LocalDateTime.now());
			err.setMessage(nhfe.getMessage());
			err.setDetails(req.getDescription(false));

			return new ResponseEntity<MyErrorDetailsCustomer>(err, HttpStatus.BAD_REQUEST);

		}

		// if method argument is not valid

		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<MyErrorDetailsCustomer> myMANVExceptionHandler(MethodArgumentNotValidException manve) {

			MyErrorDetailsCustomer err = new MyErrorDetailsCustomer();

			err.setTimestamp(LocalDateTime.now());
			err.setMessage(manve.getBindingResult().getFieldError().getDefaultMessage());
			err.setDetails("Validation error");

			return new ResponseEntity<MyErrorDetailsCustomer>(err, HttpStatus.BAD_REQUEST);

		}

}