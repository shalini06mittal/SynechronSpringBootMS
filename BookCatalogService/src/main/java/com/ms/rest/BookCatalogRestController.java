package com.ms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.bean.Catalog;
import com.ms.service.BookCatalogService;

@RestController
@RequestMapping("/catalog")
public class BookCatalogRestController {

	
	@Autowired
	private BookCatalogService bookCatalogService;
	
	@GetMapping("/{email}")
	public Catalog getCatalogDetails(@PathVariable(name="email") String email) {
		return bookCatalogService.getCatalogForUser(email);
	}
}
