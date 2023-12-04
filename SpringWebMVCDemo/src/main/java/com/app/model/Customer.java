package com.app.model;

public class Customer {

private String email;
	
	private String firstname;
	private String lastname;
	private String city;
	private String country;
	private String phone;
	private String password;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String email, String fristname, String lastname, String city, String country, String phone,
			String password) {
		super();
		this.email = email;
		this.firstname = fristname;
		this.lastname = lastname;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String fristname) {
		this.firstname = fristname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", city=" + city
				+ ", country=" + country + ", phone=" + phone + ", password=" + password + "]";
	}
	
}
