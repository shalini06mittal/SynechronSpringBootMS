package com.ms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ms.entity.BookOrder;
import com.ms.repo.BookOrderRepository;

@SpringBootApplication
public class BookOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookOrderServiceApplication.class, args);
	}
	@Bean
	public ApplicationRunner runner(BookOrderRepository repository)
	{
		return args->{
				Stream.of(new BookOrder(1, "priya@yahoo.com", 1, LocalDate.of(2022,10,10),2,"address 1"),
						new BookOrder(2, "riya@gmail.com", 2, LocalDate.of(2023, 02, 15),3,"address 2"),
						new BookOrder(3, "riya@gmail.com", 1, LocalDate.of(2022,12,20),1,"address 3"),
						new BookOrder(4, "riya@gmail.com", 5, LocalDate.of(2022,10,20),1,"address 4"),
						new BookOrder(5, "priya@yahoo.com", 10, LocalDate.of(2022,12,20),1,"address 5"),
						new BookOrder(6, "priya@yahoo.com", 5, LocalDate.of(2022,12,20),1,"address 5"),
						new BookOrder(7, "priya@yahoo.com", 7, LocalDate.of(2022,12,20),1,"address 5")
						)
				.forEach(book-> repository.save(book));
				repository.findAll().forEach(System.out::println);
				
			};
	}
}
