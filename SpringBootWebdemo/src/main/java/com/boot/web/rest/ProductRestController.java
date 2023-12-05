package com.boot.web.rest;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.web.entity.Product;
import com.boot.web.service.ProdCatService;

import jakarta.persistence.EntityNotFoundException;

@RestController // @Controller + @ResponseBody
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	private ProdCatService pService;

//	@ExceptionHandler(EntityNotFoundException.class)
//	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e){
//		System.out.println("class level handler");
//		Map<String, String> map = new HashMap();
//		map.put("message", e.getMessage());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
//	}
	
	//http://localhost:8081/products/10
//	@GetMapping("/{pid}")
//	public ResponseEntity<Object> getProductById(@PathVariable int pid) {
//		try {
//			return ResponseEntity.ok(this.pService.getProductById(pid));
//		}catch(EntityNotFoundException e) {
//			Map<String, String> map = new HashMap();
//			map.put("message", e.getMessage());
//			//return ResponseEntity.notFound().build();
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
//		}
//	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<Object> getProductById(@PathVariable int pid) {

			return ResponseEntity.ok(this.pService.getProductById(pid));
	}
	//http://localhost:8081/products?page=2&size=20  => query paramters
	@GetMapping
	public List<Product> getAllProducts(@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size){
		return this.pService.getProducts(page, size).getContent();

	}
	@PostMapping
	public Product insert(@RequestBody Product product) {
		System.out.println(product);
		return this.pService.insertorUpdateProduct(product);

	}
	// delete mapping
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteProductById(@PathVariable int id) {
		Map<String, String> map = new HashMap();
		
		try {
			if(this.pService.deleteProductById(id))
				map.put("message", "Deletion Successful");
		}catch(EntityNotFoundException e)
		{
			map.put("message", e.getMessage());
		}
		return ResponseEntity.ok(map);
	}

	// return category names



}
