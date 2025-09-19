package com.ucamp.mission.day4;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class EmployeeConfig {

	@Bean
	public EmployeeService employeeService(EmployeeRepository employeeRepository) {
		return new EmployeeServiceImpl(employeeRepository);
	}
	
	@Bean
	public EmployeeRepository employeeRepository(JdbcTemplate template) {
		return new EmployeeRepositoryImpl(template);
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/xe");
		dataSource.setUsername("SCOTT");
		dataSource.setPassword("TIGER");
		return dataSource;
	}
}
