package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieRestExceptionHandler {

	//User not found exception handler
	@ExceptionHandler
	public ResponseEntity<MovieResponseEntity> handlesExeption(UserNotFoundException unfe) {
		return new ResponseEntity<MovieResponseEntity>(new MovieResponseEntity(HttpStatus.FORBIDDEN.value(),
				unfe.getMessage(), System.currentTimeMillis()), HttpStatus.FORBIDDEN);

	}
	
	
}
