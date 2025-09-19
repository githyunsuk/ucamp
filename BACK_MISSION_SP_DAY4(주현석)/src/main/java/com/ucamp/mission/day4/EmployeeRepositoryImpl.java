package com.ucamp.mission.day4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	JdbcTemplate template;

	public EmployeeRepositoryImpl(JdbcTemplate template) {
		this.template = template;
	}

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

//		Employee employee = template.queryForObject(query, new RowMapper<Employee>() {
//			@Override
//			 public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//	            Employee e = new Employee();
//	            e.setId(rs.getString("id"));
//	            e.setName(rs.getString("name"));
//	            e.setPassword(rs.getString("password"));
//	            e.setDname(rs.getString("dname"));
//	            return e;
//	        }
//		},id);

		//람다 방식
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
