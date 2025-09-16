package com.ucamp.mission.day1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InsertProcess")
public class InsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Product p = new Product(no, name, price);
		ProductList.PRODUCT_LIST.add(p);
		
		System.out.println(ProductList.PRODUCT_LIST);
		response.sendRedirect("index.html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
