package com.boot.SpringBootDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Aadhar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aadharid;
	private String address;
	private String pic;
	@OneToOne(mappedBy = "addhar")
	private Citizen citizen;
	
	public Aadhar() {
		// TODO Auto-generated constructor stub
	}

	public Aadhar( String address, String pic) {
		this.address = address;
		this.pic = pic;
	}

	public int getAadharid() {
		return aadharid;
	}

	public void setAadharid(int aadharid) {
		this.aadharid = aadharid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	@Override
	public String toString() {
		return "Aadhar [aadharid=" + aadharid + ", address=" + address + ", pic=" + pic + ", citizen=" + citizen + "]";
	}
	
	
	
}
