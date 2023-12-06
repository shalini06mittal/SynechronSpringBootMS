package com.ms;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.ms.model.Book;
import com.ms.repo.BookRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class BookMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMicroserviceApplication.class, args);
	}
	
	@Bean
	ApplicationRunner runner(BookRepository repository)
	{
		
		return args->{
				Stream.of(new Book(1, "HarryPotter", 123.23, "Adventure Book", "Rowling"),
						new Book(2, "Adventures of Sherlock Homes", 400,"Adventure Book", "Sherlock"),
						new Book(3, "nancy Drew", 250.50,"Suspense Book", "Nancy")
						)
				.forEach(book-> repository.save(book));
				repository.findAll().forEach(System.out::println);				
			};
	}

}
