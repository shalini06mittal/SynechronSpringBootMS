package com.app.mvc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Customer;
import com.app.service.CustomerService;

/**
 * registerUser()
 * 1. after successfull registration => redirect to login page
 * 2. if unsuccessful regn> display error message on register.jsp
 * 
 * loginUser()
 * 1. to call the validateUser of CustomerService
 * 
 * profile.jsp
 * It should display the customer details for logged in user without the password information
 */
@Controller
public class HelloController {

	@Autowired
	private  CustomerService customerService;
	
	public HelloController() {
		System.out.println("Hello controller consrtuctor");
	}
	
	@GetMapping("/index")
	public String indexpage() {
		return "index";
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
	/**
	 * Session management
	 * 1. URL rewriting
	 * 2. Hidden form fields
	 * 3. cookies
	 * 4. HttpSession
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public String loginUser(@RequestParam String email,
			@RequestParam String password, HttpSession session) {
		System.out.println(email+" "+password);
		if(email.equals("sh@g.c"))
		{
			if(password.equals("sh")) {
				session.setAttribute("email", email);
				return "redirect:welcome";
			}
			else {
				return "redirect:login?error=Wrong credentials"; // viewname
			}
		}
		return "redirect:login?error=Email deos not exist";
	}
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	@PostMapping("/register")
	public String registerUser(Customer customer) {
		System.out.println(customer);
		
		
		return null;
		
	}
	@GetMapping
	public String logoutUser(HttpSession session)
	{
		session.removeAttribute("email");
		session.invalidate();
		return "redirect:login";
	}
}
