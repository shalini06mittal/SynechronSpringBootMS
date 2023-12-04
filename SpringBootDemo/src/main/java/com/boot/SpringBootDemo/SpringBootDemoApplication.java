package com.boot.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.boot.SpringBootDemo.db.EmployeeDB;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =
		SpringApplication.run(SpringBootDemoApplication.class, args);
		while(true) {
			
		}
//		EmployeeDB db = context.getBean(EmployeeDB.class);
//		System.out.println(db.getEmpCount());
	}

}
