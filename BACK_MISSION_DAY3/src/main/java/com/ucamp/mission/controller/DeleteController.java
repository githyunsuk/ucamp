package com.ucamp.mission.controller;

import java.io.IOException;

import com.ucamp.mission.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EmployeeService eService = new EmployeeService();
		boolean flag = eService.removeEmployee(id);
		
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
