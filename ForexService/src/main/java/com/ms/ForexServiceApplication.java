package com.ms;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ms.model.ForexExcchange;
import com.ms.repository.ForexExchangeRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ForexServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexServiceApplication.class, args);
	}
	
	@Autowired
	private ForexExchangeRepository repo;
	
	@PostConstruct
	public void initilaize()
	{
		ForexExcchange f1 = new ForexExcchange(1L, "USA", "IND", new BigDecimal(80.0));
		ForexExcchange f2 = new ForexExcchange(2L, "USA", "UK", new BigDecimal(50.0));
		ForexExcchange f3 = new ForexExcchange(3L, "SGP", "IND", new BigDecimal(40.0));
		repo.save(f1);
		repo.save(f2);
		repo.save(f3);
		
		System.out.println(repo.count());
		System.out.println(repo.findByFromAndTo("USA", "UK"));
	}

}
