package com.ucamp.mission2;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public Employee insertEmployee(String id, String name, String password, String dname) throws SQLException {

		Employee employee = null;
		employee = employeeRepository.insertEmployee(id, name, password, dname);

		return employee;
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) throws SQLException {

		Employee emp = null;
		emp = employeeRepository.updateEmployee(employee);

		return emp;
	}

	@Override
	@Transactional
	public Employee deleteEmployee(Employee employee) throws SQLException {

		Employee emp = null;
		emp = employeeRepository.deleteEmployee(employee);

		return emp;
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findEmployeeById(String id) throws SQLException {
		Employee employee = null;

		employee = employeeRepository.findEmployeeById(id);

		return employee;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> list = null;

		list = employeeRepository.getAllEmployees();

		return list;
	}

}
