package com.ucamp.mission.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ucamp.mission.entity.EmployeeEntity;
import com.ucamp.mission.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listController")
public class listController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public listController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeService eService = new EmployeeService();
		List<EmployeeEntity> list = null;
		list = eService.searchAllEmployee();

		request.setAttribute("list", list);
		request.getRequestDispatcher("employeeList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
