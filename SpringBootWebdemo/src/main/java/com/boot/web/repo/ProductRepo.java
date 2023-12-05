package com.boot.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.web.entity.Employee;
import com.boot.web.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	public List<Product> findByPriceGreaterThan(double amount);
	public List<Product> findByCategoryCategoryid(int id);
	
	// including break , resume at 4 pm.
	// select all prod names startwith with '' and belong to a categoryid
}

