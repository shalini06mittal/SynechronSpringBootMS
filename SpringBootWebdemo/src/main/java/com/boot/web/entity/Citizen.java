package com.boot.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String name;
	private String country;
	@OneToOne
	@JoinColumn(name="aadharid")
	
	private Aadhar addhar;
	
	public Citizen() {
		// TODO Auto-generated constructor stub
	}
	public Citizen(String name, String country, Aadhar addhar) {
		super();
		this.name = name;
		this.country = country;
		this.addhar = addhar;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Aadhar getAddhar() {
		return addhar;
	}
	public void setAddhar(Aadhar addhar) {
		this.addhar = addhar;
	}
	@Override
	public String toString() {
		return "Citizen [cid=" + cid + ", name=" + name + ", country=" + country + ", addhar=" + addhar + "]";
	}
	
}
