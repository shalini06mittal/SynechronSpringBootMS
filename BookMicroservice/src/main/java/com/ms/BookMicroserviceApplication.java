package com.ms;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.ms.model.Book;
import com.ms.repo.BookRepository;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

//http://localhost:9001/swagger-ui.html

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
						new Book(3, "nancy Drew", 250.50,"Suspense Book", "Nancy"),
						new Book(4, "Book 4", 123.23, "Book 4 details", "Book 4 author"),
						new Book(5, "Book 5", 523.23, "Book 5 details", "Book 5 author"),
						new Book(6, "Book 6", 823.23, "Book 6 details", "Book 6 author"),
						new Book(7, "Book 7", 1923.23, "Book 7 details", "Book 7 author"),
						new Book(8, "Book 8", 4123.23, "Book 8 details", "Book 8 author"),
						new Book(9, "Book 9", 83.23, "Book 9 details", "Book 9 author"),
						new Book(10, "Book 10", 1890, "Book 10 details", "Book 10 author"),
						new Book(11, "Book 11", 657, "Book 11 details", "Book 11 author")
						)
				.forEach(book-> repository.save(book));
				repository.findAll().forEach(System.out::println);				
			};
	}
	@Bean
	OpenAPI info() {
		return new OpenAPI().info(
				new Info().contact(new Contact()
						.email("dummy@gmail.com")
						.name("Synechron")
						.url("http://www.techgatha.com"))
						.description("Allows to access books")
						.summary("It is REST API for testing and learning purpose")
						.termsOfService("some url")
						.title("BOOK MICROSERVICE")
				);
	}

}







