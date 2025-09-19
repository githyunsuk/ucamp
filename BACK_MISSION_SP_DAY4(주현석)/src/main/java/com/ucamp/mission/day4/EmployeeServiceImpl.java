package com.ucamp.mission.day4;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee insertEmployee(String id, String name, String password, String dname) {
	
		Employee employee = null;
		try {
			employee = employeeRepository.insertEmployee(id, name, password, dname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		Employee emp = null;
		try {
			emp = employeeRepository.updateEmployee(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public Employee deleteEmployee(Employee employee) {
		
		Employee emp = null;
		try {
			emp = employeeRepository.deleteEmployee(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public Employee findEmployeeById(String id) {
		Employee employee = null;
		
		try {
			employee = employeeRepository.findEmployeeById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = null;
		
		try {
			list = employeeRepository.getAllEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
