package com.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.web.entity.Aadhar;
import com.boot.web.entity.Category;
import com.boot.web.entity.Citizen;
import com.boot.web.entity.Product;
import com.boot.web.repo.AadharRepo;
import com.boot.web.repo.CategoryRepo;
import com.boot.web.repo.CitizenRepo;
import com.boot.web.repo.ProductRepo;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootWebdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebdemoApplication.class, args);
	}

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private AadharRepo repo;
	
	@Autowired
	private CitizenRepo citizenRepo;
	
	@PostConstruct
	public void initialize() {
		Aadhar a1=new Aadhar("street mumbai", "img1.png");
		Aadhar a2=new Aadhar("street chennai", "img2.png");
		
		repo.save(a1);
		repo.save(a2);
		
		Citizen c1 = new Citizen("shalini","India",a1);
		Citizen c2 = new Citizen("manish","India",a2);
		citizenRepo.save(c1);
		citizenRepo.save(c2);
		
		Citizen c = citizenRepo.findById(1).get();
		//System.out.println(c.getCid()+" "+c.getName()+" "+c.getAddhar().getAadharid()+" "+c.getAddhar().getAddress());
		//System.out.println(c);
		
		Aadhar a = repo.findById(1).get();
		System.out.println(a.getAadharid()+" "+a.getAddress()+" "+a.getCitizen().getName());
		
	}
	
	//@Bean
	@PostConstruct
	public void insertDummydata() {
			Category cat1 = new Category();
			cat1.setCategoryname("Electronics");
			
			Category cat2 = new Category();
			cat2.setCategoryname("Appliances");
			
			Category cat3 = new Category();
			cat3.setCategoryname("Bakery");
			
			Category cat4 = new Category();
			cat4.setCategoryname("Board Games");
			cat1 = categoryRepo.save(cat1);
			cat2 = categoryRepo.save(cat2);
			cat3 = categoryRepo.save(cat3);
			cat4 = categoryRepo.save(cat4);
			
			Product p1 = new Product("LED TV", "Enhance features", 34987, cat1);
			Product p2 = new Product("Mixer", "A food mixer and grinders", 2345, cat2);
			Product p3 = new Product("Cookies", "Chocolate cookies n cream", 199, cat3);
			Product p4 = new Product("monopoly", "To teach business", 2398, cat4);
			productRepo.save(p1);
			productRepo.save(p2);
			productRepo.save(p3);
			productRepo.save(p4);
			
//			Category cat1 = categoryRepo.findById(1).get();
//			Category cat2 = categoryRepo.findById(2).get();
//			Category cat3 = categoryRepo.findById(3).get();
//			Category cat4 = categoryRepo.findById(4).get();
			for(int i=5 ; i<=25 ; i++) {
				productRepo.save(new Product("Prod "+i, "Desc "+i, 237* i, cat1));
			}
			for(int i=26 ; i<=45 ; i++) {
				productRepo.save(new Product("Prod "+i, "Desc "+i, 237* i, cat2));
			}
			for(int i=46 ; i<=55 ; i++) {
				productRepo.save(new Product("Prod "+i, "Desc "+i, 237* i, cat3));
			}
			for(int i=56 ; i<=75 ; i++) {
				productRepo.save(new Product("Prod "+i, "Desc "+i, 237* i, cat4));
			}
			
	}
	
}
