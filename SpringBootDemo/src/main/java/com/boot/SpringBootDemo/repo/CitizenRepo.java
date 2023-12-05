package com.boot.SpringBootDemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.SpringBootDemo.entity.Category;
import com.boot.SpringBootDemo.entity.Citizen;
import com.boot.SpringBootDemo.entity.Employee;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{

	//public Citizen findByAadharAadharid(int id);
	
}

