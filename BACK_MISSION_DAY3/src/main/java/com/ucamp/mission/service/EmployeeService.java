package com.ucamp.mission.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ucamp.mission.dao.EmployeeDAO;
import com.ucamp.mission.entity.EmployeeEntity;
import com.ucamp.util.JdbcUtil;

public class EmployeeService {

	EmployeeDAO eDAO;
	Connection conn;

	public EmployeeService() {
		try {
			conn = JdbcUtil.createConnection();
			eDAO = new EmployeeDAO(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean addEmployee(EmployeeEntity eEntity) {
		boolean flag = false;

		try {
			eDAO.insertEmployee(eEntity);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;

	}

	public boolean modifyEmployee(EmployeeEntity eEntity) {
		boolean flag = false;
		
		try {
			eDAO.updateEmployee(eEntity);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	public boolean removeEmployee(String id) {
		boolean flag = false;
		
		try {
			eDAO.deleteEmployee(id);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	public EmployeeEntity searchOneEmployee(String id) {
		EmployeeEntity eEntity = null;
		
		try {
			eEntity = eDAO.selectOneEmployee(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return eEntity;
	}
	public List<EmployeeEntity> searchAllEmployee() {
		List<EmployeeEntity> list = null;
		
		try {
			list = eDAO.selectAllEmployee();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
