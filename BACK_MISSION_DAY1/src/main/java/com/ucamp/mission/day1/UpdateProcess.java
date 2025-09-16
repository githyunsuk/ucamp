package com.ucamp.mission.day1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UpdateProcess")
public class UpdateProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		for(Product product : ProductList.PRODUCT_LIST) {
			if(no.equals(product.getNo())){
				product.setNo(no);
				product.setName(name);
				product.setPrice(price);
			}
		}
		
		response.sendRedirect("index.html");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
