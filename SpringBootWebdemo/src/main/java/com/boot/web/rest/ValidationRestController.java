package com.boot.web.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.web.entity.Input;

import jakarta.validation.Valid;

@RestController
public class ValidationRestController {

	@PostMapping("/input")
	public Input takeInput(@Valid @RequestBody Input input)
	{
		
		return input;
	}
	
}
