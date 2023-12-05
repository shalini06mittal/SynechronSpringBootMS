package com.boot.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloCOntroller {

	public HelloCOntroller() {
		System.out.println("Hello controller");
	}
	@GetMapping("/")
	public String greet()
	{
		System.out.println("greet");
		return "index";
	}
	
}
