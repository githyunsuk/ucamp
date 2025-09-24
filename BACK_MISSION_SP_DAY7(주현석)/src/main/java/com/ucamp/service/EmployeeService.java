package com.ucamp.service;

import java.util.List;

import com.ucamp.entity.EmployeeDTO;

public interface EmployeeService {

	public int addEmployee(EmployeeDTO employee);
	public int modifyEmployee(EmployeeDTO employee);
	public int removeEmployee(String id);
	public EmployeeDTO searchEmployee(String id);
	public List<EmployeeDTO> searchAllEmployee();
}
