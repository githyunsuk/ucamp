package com.ucamp.mission.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ucamp.mission.entity.EmployeeEntity;
import com.ucamp.mission.service.EmployeeService;

@WebServlet("/updateFormController")
public class UpdateFormController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EmployeeService eService = new EmployeeService();
		EmployeeEntity eEntity = eService.searchOneEmployee(id);
		
		request.setAttribute("employee", eEntity);
		request.getRequestDispatcher("updateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
