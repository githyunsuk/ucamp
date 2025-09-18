package com.ucamp.mission.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ucamp.mission.entity.EmployeeEntity;
import com.ucamp.mission.service.EmployeeService;

@WebServlet("/updateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String dname = request.getParameter("dname");
		
		EmployeeEntity eEntity = new EmployeeEntity(id, name, password, dname);
		EmployeeService eService = new EmployeeService();
		boolean flag = eService.modifyEmployee(eEntity);
		
		if(flag == true) {
			response.sendRedirect("manager.html");
			return;
		}
		
		response.sendRedirect("fail.html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
