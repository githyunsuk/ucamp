package com.ucamp.mission.day2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listProc")
public class listProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public listProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<EmployeeDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "scott", "TIGER");
		
			String sql = "select id, name, substr(password, 1, 2) || '**' as password, dname from employee";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			EmployeeDTO eDTO = null;
			while(rs.next()) {
				eDTO = new EmployeeDTO();
				eDTO.setId(rs.getString("id"));
				eDTO.setName(rs.getString("name"));
				eDTO.setPassword(rs.getString("password"));
				eDTO.setDname(rs.getString("dname"));
				list.add(eDTO);
			}
			
			request.setAttribute("list", list);  
			request.getRequestDispatcher("employeeList.jsp").forward(request, response);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
