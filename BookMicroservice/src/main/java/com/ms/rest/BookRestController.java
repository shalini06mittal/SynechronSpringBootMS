package com.ms.rest;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.Book;
import com.ms.repo.BookRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/books")
public class BookRestController {

	@Autowired
	private BookRepository bookRepository;
	
	@Operation(summary = "Get book by id")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "Book found",
							content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = Book.class)
							)}),
					@ApiResponse(responseCode = "404", description = "Book not found")
					}
			)
	@GetMapping("/{id}")
	public Book getBookById(@Parameter(description = "Id is requiresd to get the book") @PathVariable(name="id",required = false) int id,
			@RequestParam(required = false) String msg
			) {
//		System.out.println("now "+LocalTime.now());
//		if(id==10)
//			throw new EntityNotFoundException("book with "+id+" not found");
		
		return bookRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(id + " not found"));
	}
	@GetMapping("title/{title}")
	public Book getBookById1(@PathVariable(name="title") String title) {
		return bookRepository.findByTitle(title);
	}
	@GetMapping
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
}
