package com.oneStopSolutions.admin.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice // AOP Aspect Oriented Programming
public class GlobalAdminExceptionHandler {

	//Handler for Admin Exception

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorAdminBean> ExceptionHandler1(AdminException ae, WebRequest req) {

		MyErrorAdminBean err = new MyErrorAdminBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	//Handler for Employee Exception

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyErrorAdminBean> ExceptionHandler2(EmployeeException ae, WebRequest req) {

		MyErrorAdminBean err = new MyErrorAdminBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}


	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<MyErrorAdminBean> ExceptionHandler3(DepartmentException ae, WebRequest req) {

		MyErrorAdminBean err = new MyErrorAdminBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	// Handler for any other Exception

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorAdminBean> genericExceptionHandler4(Exception ae, WebRequest req) {

		MyErrorAdminBean err = new MyErrorAdminBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	// No Handler Found Exception

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorAdminBean> myexpHandler5(NoHandlerFoundException ae, WebRequest req) {

		MyErrorAdminBean err = new MyErrorAdminBean();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	//Handler for Method Argument not valid Exception

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorAdminBean> myMANVExceptionHandler6(MethodArgumentNotValidException me) {

		MyErrorAdminBean err = new MyErrorAdminBean();

		err.setTimestamp(LocalDateTime.now());
		err.setDetails("Validation Error");
		err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

}
