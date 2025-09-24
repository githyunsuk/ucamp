package com.ucamp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucamp.entity.EmployeeDTO;
import com.ucamp.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	@Override
	public int addEmployee(EmployeeDTO employee) {
		return employeeRepository.insertEmployee(employee);
	}

	@Override
	public int modifyEmployee(EmployeeDTO employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public int removeEmployee(String id) {
		return employeeRepository.deleteEmployee(id);
	}

	@Override
	public EmployeeDTO searchEmployee(String id) {
		return employeeRepository.selectEmployee(id);
	}

	@Override
	public List<EmployeeDTO> searchAllEmployee() {
		return employeeRepository.selectAllEmployee();
	}

}
