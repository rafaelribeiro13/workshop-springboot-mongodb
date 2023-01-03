package com.course.workshopmongo.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.course.workshopmongo.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e
			, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		String error = "Object not found";
		String path = request.getRequestURI();
		
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), path);
		return ResponseEntity.status(status).body(err);
	}
	
}
