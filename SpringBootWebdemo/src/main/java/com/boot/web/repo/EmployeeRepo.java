package com.boot.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.web.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	public List<Employee> findByCity(String city);
	public List<Employee> findByEname(String ename);
}

