package com.ucamp.mission.day1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteProcess")
public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		Product temp = null;
		for(Product product : ProductList.PRODUCT_LIST) {
			if(no.equals(product.getNo())){
				temp = product;
			}
		}
		ProductList.PRODUCT_LIST.remove(temp);
		
		response.sendRedirect("index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
