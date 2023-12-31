package com.app.mvc;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.model.Customer;
import com.app.service.CustomerService;

@Controller
public class DashboardController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/welcome")
	public String welcomePage() {
		return "welcome";
	}
	@GetMapping("/profile")
	public String profilePage(HttpSession session, Map<String, Customer> map) {
		String email = (String) session.getAttribute("email");
		Customer customer = customerService.getCustomerById(email);
		map.put("customer", customer);
		return "profile";
	}
}
