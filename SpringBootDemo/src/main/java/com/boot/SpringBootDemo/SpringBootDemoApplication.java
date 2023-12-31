package com.boot.SpringBootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import com.boot.SpringBootDemo.db.EmployeeDB;
import com.boot.SpringBootDemo.entity.Aadhar;
import com.boot.SpringBootDemo.entity.Category;
import com.boot.SpringBootDemo.entity.Citizen;
import com.boot.SpringBootDemo.entity.Employee;
import com.boot.SpringBootDemo.entity.Product;
import com.boot.SpringBootDemo.repo.AadharRepo;
import com.boot.SpringBootDemo.repo.CategoryRepo;
import com.boot.SpringBootDemo.repo.CitizenRepo;
import com.boot.SpringBootDemo.repo.ProductRepo;
import com.boot.SpringBootDemo.service.EmployeeService;
import com.boot.SpringBootDemo.service.ProdCatService;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =
		SpringApplication.run(SpringBootDemoApplication.class, args);
//		EmployeeDB db = context.getBean(EmployeeDB.class);
//		System.out.println(db.getEmpCount());
//		try {
//			System.out.println(db.insertEmployee(new Employee(1, "Shalini", "Mumbai")));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(db.getEmpCount());
		
//		EmployeeService employeeService = context.getBean(EmployeeService.class);
//		
//		Employee e1 = new Employee();
//		e1.setEname("Shalini");
//		e1.setCity("Mumbai");
//		
//		Employee e2 = new Employee();
//		e2.setEname("Ajay");
//		e2.setCity("Pune");
//		
//		Employee e3 = new Employee();
//		e3.setEid(1);
//		e3.setEname("Akshaya");
//		e3.setCity("Chennai");
//		
//		System.out.println(employeeService.insertEmployee(e1));
//		System.out.println(employeeService.insertEmployee(e2));
//		try {
//		System.out.println(employeeService.insertEmployee(e3));
//		}
//		catch(EntityExistsException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println(employeeService.getCount());
//		
//		System.out.println();
//		for(Employee emp : employeeService.getAllEmployees())
//			System.out.println(emp);
//		
//		e1.setEname("Shalini Mittal");
//		System.out.println(employeeService.updateEmployee(e1));
//		
//		//employeeService.deleteEmployeeById(1);
//		System.out.println(employeeService.getCount());
//		try {
//		employeeService.deleteEmployeeById(1);
//		}catch(EntityNotFoundException e)
//		{
//			System.out.println(e.getMessage());
//		}
//		
//		for(Employee e:employeeService.getAllEmployeesByCity("mumbai"))
//			System.out.println(e);
//		
//		for(Employee e:employeeService.getAllEmployeesByName("neha"))
//			System.out.println(e);
		
		ProdCatService service = context.getBean(ProdCatService.class);
//		for(Product p: service.getAllProductsByCategoryId(1))
//			System.out.println(p);
//		
//		for(Product p: service.getAllProductsByPriceGreaterThan(10000))
//			System.out.println(p);
//		
//		System.out.println(service.getCategoryNames());
		
//		Page<Product> page = service.getProducts(0, 12);
//		System.out.println(page.getNumber());
//		System.out.println(page.getNumberOfElements());
//		System.out.println(page.getSize());
//		System.out.println(page.getTotalElements());
//		System.out.println(page.getTotalPages());
//		System.out.println(page.isFirst());
//		for(Product p:page.getContent())
//			System.out.println(p.getPid()+" "+p.getProdname());
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
//		Aadhar a1=new Aadhar("street mumbai", "img1.png");
//		Aadhar a2=new Aadhar("street chennai", "img2.png");
//		
//		repo.save(a1);
//		repo.save(a2);
//		
//		Citizen c1 = new Citizen("shalini","India",a1);
//		Citizen c2 = new Citizen("manish","India",a2);
//		citizenRepo.save(c1);
//		citizenRepo.save(c2);
		
		Citizen c = citizenRepo.findById(1).get();
		//System.out.println(c.getCid()+" "+c.getName()+" "+c.getAddhar().getAadharid()+" "+c.getAddhar().getAddress());
		//System.out.println(c);
		
//		Aadhar a = repo.findById(1).get();
//		System.out.println(a.getAadharid()+" "+a.getAddress()+" "+a.getCitizen().getName());
		
	}
	
	//@Bean
	//@PostConstruct
	public void insertDummydata() {
//			Category cat1 = new Category();
//			cat1.setCategoryname("Electronics");
//			
//			Category cat2 = new Category();
//			cat2.setCategoryname("Appliances");
//			
//			Category cat3 = new Category();
//			cat3.setCategoryname("Bakery");
//			
//			Category cat4 = new Category();
//			cat4.setCategoryname("Board Games");
//			categoryRepo.save(cat1);
//			categoryRepo.save(cat2);
//			categoryRepo.save(cat3);
//			categoryRepo.save(cat4);
//			
//			Product p1 = new Product("LED TV", "Enhance features", 34987, cat1);
//			Product p2 = new Product("Mixer", "A food mixer and grinders", 2345, cat2);
//			Product p3 = new Product("Cookies", "Chocolate cookies n cream", 199, cat3);
//			Product p4 = new Product("monopoly", "To teach business", 2398, cat4);
//			productRepo.save(p1);
//			productRepo.save(p2);
//			productRepo.save(p3);
//			productRepo.save(p4);
			
			Category cat1 = categoryRepo.findById(1).get();
			Category cat2 = categoryRepo.findById(2).get();
			Category cat3 = categoryRepo.findById(3).get();
			Category cat4 = categoryRepo.findById(4).get();
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
