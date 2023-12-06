package com.ms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.Book;
import com.ms.repo.BookRepository;

@RestController
@RequestMapping("/books")
public class BookRestController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable(name="id") int id) {
		
		
		return bookRepository.findById(id).get();
	}
}
