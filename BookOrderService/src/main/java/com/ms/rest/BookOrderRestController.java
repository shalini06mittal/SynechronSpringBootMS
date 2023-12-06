package com.ms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.BookOrder;
import com.ms.repo.BookOrderRepository;

@RestController
@RequestMapping("/orders")
public class BookOrderRestController {
	
	@Autowired
	private BookOrderRepository bookOrderRepository;

	@GetMapping("/{email}")
	public List<BookOrder> getAllOrderBy(@PathVariable(name="email") String email)
	{
		return this.bookOrderRepository.findAllByEmail(email);
	}
}
