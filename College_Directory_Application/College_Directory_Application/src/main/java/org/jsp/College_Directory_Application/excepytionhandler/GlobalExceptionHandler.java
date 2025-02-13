package org.jsp.College_Directory_Application.excepytionhandler;

import org.jsp.College_Directory_Application.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> runtimeExceptionHandler(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder()
				.status(HttpStatus.BAD_REQUEST.value()).message("Something went Wrong").body(e.getMessage()).build());
	}

}
