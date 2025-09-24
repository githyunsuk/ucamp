package com.ucamp.repository;

import java.util.List;

import com.ucamp.entity.EmployeeDTO;

public interface EmployeeRepository {

	public int insertEmployee(EmployeeDTO employee);
	public int updateEmployee(EmployeeDTO employee);
	public int deleteEmployee(String id);
	public EmployeeDTO selectEmployee(String id);
	public List<EmployeeDTO> selectAllEmployee();
}
