package com.boot.SpringBootDemo.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.boot.SpringBootDemo.entity.Employee;

@Repository
public class EmployeeDB {
	
	@Autowired
	private JdbcTemplate template;
	
	public long getEmpCount() {
		return this.template.queryForObject("select count(*) from emp", Long.class);
	}
	
	public Employee insertEmployee(Employee emp) throws Exception
	{
//		String sql = "insert into emp values(?,?,?)";
//		try {
//			this.template.update(sql, emp.getEid(), emp.getEname(), emp.getCity() );
//		}
//		catch(Exception e) {
//			throw new Exception(e.getMessage());
//		}
		return emp;
	}

	public Employee getEmployeeByEid(int eid) throws Exception {
		String sql = "select * from emp where eid=?";
		/**
		 * 
		 */
		try {
		return this.template.queryForObject(sql, new EmployeeRowMapper(), eid);
		}catch(DataAccessException e) {
			throw new Exception("Email does not exist");
		}
	}
	
	public List<Employee> getEmployees()  {
		String sql = "select * from Employee";

		return this.template.query(sql, new EmployeeRowMapper());
	}


	class EmployeeRowMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee();
			emp.setEid(rs.getInt(1));
			//emp.setEname(rs.getString(2));
			emp.setCity(rs.getString(3));
			
			return emp;
		}

	}




}
