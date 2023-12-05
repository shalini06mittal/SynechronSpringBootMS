package com.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.web.entity.Employee;
import com.boot.web.repo.EmployeeRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public long getCount()
	{
		return this.employeeRepo.count();
	}
	
	public Employee insertEmployee(Employee employee) {
		if(this.employeeRepo.existsById(employee.getEid()))
			throw new EntityExistsException("Cannot insert as id already exists");
		return this.employeeRepo.save(employee);
	}
	public Employee updateEmployee(Employee employee) {
		if(!this.employeeRepo.existsById(employee.getEid()))
			throw new EntityNotFoundException("Cannot update as id does not exists");
		return this.employeeRepo.save(employee);
	}
	
	public void deleteEmployeeById(int eid) {
		if(!this.employeeRepo.existsById(eid))
			throw new EntityNotFoundException("Cannot deletes as id does not exists");
		 this.employeeRepo.deleteById(eid);
	}
	
	public List<Employee> getAllEmployees(){
		return this.employeeRepo.findAll();
	}
	
	public List<Employee> getAllEmployeesByCity(String city){
		return this.employeeRepo.findByCity(city);
	}
	
	public List<Employee> getAllEmployeesByName(String name){
		return this.employeeRepo.findByEname(name);
	}
	
	
}
