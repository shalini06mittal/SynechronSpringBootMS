package com.boot.SpringBootDemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String prodname;
	@Column(name="description")
	private String desc;
	private double price;
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String prodname, String desc, double price, Category category) {
		super();
		this.prodname = prodname;
		this.desc = desc;
		this.price = price;
		this.category = category;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", prodname=" + prodname + ", desc=" + desc + ", price=" + price + ", category="
				+ category + "]";
	}
	
}
