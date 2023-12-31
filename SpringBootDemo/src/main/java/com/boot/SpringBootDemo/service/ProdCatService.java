package com.boot.SpringBootDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.boot.SpringBootDemo.entity.Product;
import com.boot.SpringBootDemo.repo.CategoryRepo;
import com.boot.SpringBootDemo.repo.ProductRepo;

@Service
public class ProdCatService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAllProductsByCategoryId(int id)
	{
		return productRepo.findByCategoryCategoryid(id);
	}
	
	public List<Product> getAllProductsByPriceGreaterThan(double amt)
	{
		return productRepo.findByPriceGreaterThan(amt);
	}
	public List<String> getCategoryNames(){
		return categoryRepo.getAllCategoryNames();
	}
	
	public Page<Product> getProducts(int pageno, int size){
		
		
		Pageable pageable = PageRequest.of(pageno, size, Direction.ASC,"prodname");
		Page<Product> page = this.productRepo.findAll(pageable);
		return page;
		
	}
	
}
