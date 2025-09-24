package com.ucamp.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ucamp.entity.EmployeeDTO;
import com.ucamp.exception.UpdateFailNotExistException;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public int insertEmployee(EmployeeDTO employee) {
		String query = "insert into employee(id, name, password, dname) values(?, ?, ?, ?)";
		int row = jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getPassword(),
				employee.getDname());

		return row;
	}

	@Override
	public int updateEmployee(EmployeeDTO employee) {
		String query = "update employee set name = ?, password = ?, dname = ? where id = ?";
		int row = jdbcTemplate.update(query, employee.getName(), employee.getPassword(), employee.getDname(),
				employee.getId());
		
		if(row < 1) {
			throw new UpdateFailNotExistException("존재하지 않는 사원입니다.");
		}
		
		return row;
	}

	@Override
	public int deleteEmployee(String id) {
		String query = "delete from employee where id = ?";
		int row = jdbcTemplate.update(query, id);
		
		if(row < 1) {
			throw new UpdateFailNotExistException("존재하지 않는 사원입니다.");
		}

		return row;
	}

	@Override
	public EmployeeDTO selectEmployee(String id) {
		String query = "select * from employee where id = ?";
		return jdbcTemplate.queryForObject(query, (rs, rowNum) -> new EmployeeDTO(rs.getString("id"),
				rs.getString("name"), rs.getString("password"), rs.getString("dname")), id);
	}

	@Override
	public List<EmployeeDTO> selectAllEmployee() {
		String query = "select * from employee";
		return jdbcTemplate.query(query, (rs, rowNum) -> new EmployeeDTO(rs.getString("id"),
				rs.getString("name"), rs.getString("password"), rs.getString("dname")));
	
	}

}
