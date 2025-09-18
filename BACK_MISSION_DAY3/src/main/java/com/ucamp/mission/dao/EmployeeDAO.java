package com.ucamp.mission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ucamp.mission.entity.EmployeeEntity;
import com.ucamp.util.JdbcUtil;

public class EmployeeDAO {

	Connection conn;
	
	public EmployeeDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void insertEmployee(EmployeeEntity eEntity) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			
			String sql = "INSERT INTO EMPLOYEE(ID, NAME, PASSWORD, DNAME) VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eEntity.getId());
			pstmt.setString(2, eEntity.getName());
			pstmt.setString(3, eEntity.getPassword());
			pstmt.setString(4, eEntity.getDname());
			pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	
	public void updateEmployee(EmployeeEntity eEntity) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "update employee set name = ?, password = ?, dname = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eEntity.getName());
			pstmt.setString(2, eEntity.getPassword());
			pstmt.setString(3, eEntity.getDname());
			pstmt.setString(4, eEntity.getId());
			pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	
	public void deleteEmployee(String id) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from employee where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	
	public EmployeeEntity selectOneEmployee(String id) throws SQLException {
		EmployeeEntity eEntity = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select id, name, password, dname from employee where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				eEntity = new EmployeeEntity();
				eEntity.setId(rs.getString("id"));
				eEntity.setName(rs.getString("name"));
				eEntity.setPassword(rs.getString("password"));
				eEntity.setDname(rs.getString("dname"));
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return eEntity;
		
	}
	
	public List<EmployeeEntity> selectAllEmployee() throws SQLException {
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select id, name, substr(password, 1, 2) || '**' as password, dname from employee";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				EmployeeEntity eEntity = new EmployeeEntity();
				eEntity.setId(rs.getString("id"));
				eEntity.setName(rs.getString("name"));
				eEntity.setPassword(rs.getString("password"));
				eEntity.setDname(rs.getString("dname"));
				list.add(eEntity);
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return list;
		
	}
}
