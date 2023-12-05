package com.boot.web.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class MyGlobalExceptionHandler {

	public MyGlobalExceptionHandler() {
		System.out.println("my global handler");
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e){
		System.out.println("global level handler");
		Map<String, String> map = new HashMap();
		map.put("message", e.getMessage());
		map.put("status", "FAILURE");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
