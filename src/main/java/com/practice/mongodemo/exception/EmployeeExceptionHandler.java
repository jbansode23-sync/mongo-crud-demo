package com.practice.mongodemo.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice	
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	protected ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(RuntimeException ex, WebRequest request) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setDescription(ex.getMessage());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	protected ResponseEntity<ErrorResponse> handleDuplicateKeyExistsException(RuntimeException ex, WebRequest request){
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setDescription(ex.getMessage());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
