package com.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.boot.web.entity.Category;
import com.boot.web.entity.Product;
import com.boot.web.repo.CategoryRepo;
import com.boot.web.repo.ProductRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdCatService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public Product getProductById(int pid) {
		return productRepo.findById(pid)
				.orElseThrow(()-> new EntityNotFoundException("Product does not exist"));
	}
	
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
		Pageable pageable = PageRequest.of(pageno, size);//, Direction.ASC,"prodname");
		Page<Product> page = this.productRepo.findAll(pageable);
		return page;
		
	}
	
	public Product insertorUpdateProduct(Product product) {
		int cid = product.getCategory().getCategoryid();
		Category category = categoryRepo.findById(cid).get();
		product.setCategory(category);
		return productRepo.save(product);
	}
	public boolean deleteProductById(int pid) {
		if(!productRepo.existsById(pid))
			throw new EntityNotFoundException("Cannot deletes as id does not exists");
		 this.productRepo.deleteById(pid);
		 return true;
			
	}
}
