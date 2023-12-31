package com.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Customer;

@Service
public class CustomerService {

	private List<Customer> customers = new ArrayList<>();
	
	public CustomerService() {
		customers.add(new Customer("sh@g.c", "Shalini", "Mittal", "Mumbai", "India","132121123", "sh"));
		customers.add(new Customer("ab@g.c", "Abhishekh", "Garg", "Mumbai", "India","132121123", "ab"));
	}
	public List<Customer> getAllCustomers()
	{
		return customers;
	}
	public Customer getCustomerById(String email) {
		for(Customer customer : customers) {
			if(customer.getEmail().equals(email))
				return customer;
		}
		throw new RuntimeException("customer with" +email+" does not exist");
	}
	public boolean insertCustomer(Customer customer) {
		for(int i=0;i<customers.size();i++)
			if(customers.get(i).getEmail().equals(customer.getEmail()))
				throw new RuntimeException("customer with " +customer.getEmail()+" already exist");
		customers.add(customer);
		return true;
	}
	public boolean validateUser(String email, String password) {
		for(Customer customer : customers) {
			if(customer.getEmail().equals(email))
				if(customer.getPassword().equals(password))
					return true;
				else
					throw new RuntimeException("Invalid credentials");
		}
		throw new RuntimeException("Customer not registered");
	}
}
