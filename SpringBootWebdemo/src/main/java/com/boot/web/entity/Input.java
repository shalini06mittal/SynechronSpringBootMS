package com.boot.web.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class Input {

	@Min(1)
	@Max(100)
	private int number;
	
	@Email
	private String email;
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Input [number=" + number + ", email=" + email + "]";
	}
	
	
}
