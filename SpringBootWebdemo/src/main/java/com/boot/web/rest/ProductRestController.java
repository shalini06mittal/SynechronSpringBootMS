package com.boot.web.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.web.entity.Product;
import com.boot.web.service.ProdCatService;

@RestController // @Controller + @ResponseBody
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	private ProdCatService pService;
	
	//http://localhost:8081/products/10
	@GetMapping("/{pid}")
	public Product getProductById(@PathVariable int pid) {
		return this.pService.getProductById(pid);
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
	
	// return category names
	
	// update
	
}
