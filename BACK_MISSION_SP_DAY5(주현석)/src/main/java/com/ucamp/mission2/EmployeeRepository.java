package com.ucamp.mission2;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {

	public Employee insertEmployee(String id, String name, String password, String dname) throws SQLException;
	
	public Employee updateEmployee(Employee employee) throws SQLException;
	
	public Employee deleteEmployee(Employee employee) throws SQLException;
	
	public Employee findEmployeeById(String id) throws SQLException;
	
	public List<Employee> getAllEmployees() throws SQLException;
}
