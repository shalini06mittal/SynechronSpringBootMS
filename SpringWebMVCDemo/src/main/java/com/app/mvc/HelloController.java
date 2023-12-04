package com.app.mvc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	public HelloController() {
		System.out.println("Hello controller consrtuctor");
	}
	@RequestMapping("/hello")
	public String hello()
	{
		System.out.println("hello called");
		return "greet";// viewname
	}
	
	@GetMapping("/login")
	public String loginPage(Map<String, List<String>> map,
			Map<String, String> errmsg,
			@RequestParam(required = false) String error
			) {
		System.out.println("GET Login");
		// db => list of al the roles -> model
		if(error != null)
			errmsg.put("error", error);
		List<String> roles = Arrays.asList("dev","admin","tester","IT");
		map.put("roles", roles);
		return "login";
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam String email,
			@RequestParam String password) {
		System.out.println(email+" "+password);
		if(email.equals("sh@g.c"))
		{
			if(password.equals("sh"))
				return "welcome";
			else {
				return "redirect:login?error=Wrong credentials"; // viewname
			}
		}
		return "redirect:login?error=Email deos not exist";
	}
}
