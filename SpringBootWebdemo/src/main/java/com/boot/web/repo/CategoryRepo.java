package com.boot.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.web.entity.Category;
import com.boot.web.entity.Employee;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	// select categoryname from category
	
	@Query("select categoryname from Category")
	public List<String> getAllCategoryNames();
	
	
}

