package com.spring.SpringCoreDemo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfiguration {

	@Bean
	public DataSource dataSource()
	{
		System.out.println("datasource object created");
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:8889/synechron");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean
	@Autowired
	public JdbcTemplate template(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
}
