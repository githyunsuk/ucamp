package com.ucamp.mission2;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private final JdbcTemplate template;

	@Override
	public Employee insertEmployee(String id, String name, String password, String dname) throws SQLException {

		String query = "insert into employee values(?, ?, ?, ?)";
		int row = template.update(query, id, name, password, dname);

		if (row != 0) {
			return new Employee(id, name, password, dname);
		}

		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws SQLException {

		String query = "update employee set name = ?, password = ?, dname = ? where id = ?";
		int row = template.update(query, employee.getName(), employee.getPassword(), employee.getDname(),
				employee.getId());

		if (row != 0) {
			return employee;
		}

		return null;
	}

	@Override
	public Employee deleteEmployee(Employee employee) throws SQLException {

		String query = "delete from employee where id = ?";
		int row = template.update(query, employee.getId());

		if (row != 0) {
			return employee;
		}

		return null;
	}

	@Override
	public Employee findEmployeeById(String id) throws SQLException {

		String query = "select id, name, password, dname from employee where id = ?";

		Employee employee = template.queryForObject(query, (rs, rowNum) -> new Employee(rs.getString("id"),
				rs.getString("name"), rs.getString("password"), rs.getString("dname")), id);

		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		String query = "select id, name, password, dname from employee";
	
		List<Employee> list = template.query(query, (rs, rowNum) -> new Employee(rs.getString("id"),
				rs.getString("name"), rs.getString("password"), rs.getString("dname")));
	
		return list;
	}

}
