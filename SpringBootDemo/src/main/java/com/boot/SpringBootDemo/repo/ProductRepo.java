package com.boot.SpringBootDemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.SpringBootDemo.entity.Employee;
import com.boot.SpringBootDemo.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	public List<Product> findByPriceGreaterThan(double amount);
	public List<Product> findByCategoryCategoryid(int id);
	
}

