package com.ucamp.mission.day4;

import java.util.List;

public interface EmployeeService {

	public Employee insertEmployee(String id, String name, String password, String dname);

	public Employee updateEmployee(Employee employee);

	public Employee deleteEmployee(Employee employee);

	public Employee findEmployeeById(String id);

	public List<Employee> getAllEmployees();
}
