package com.ucamp.mission.day1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateForm")
public class UpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String no = request.getParameter("no");
		
		Product product = null;
		for(Product p : ProductList.PRODUCT_LIST) {
			if(no.equals(p.getNo())) product = p;
		}
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>제품 정보 입력</h1><hr>");
		out.print("<form action='UpdateProcess'>");
		out.print("<label>제품 번호</label> <input type='text' name='no' value='" + product.getNo() + "'><br>");
		out.print("<label>제품 이름</label> <input type='text' name='name' value='" + product.getName() + "'><br>");
		out.print("<label>제품 가격</label> <input type='text' name='price' value='" + product.getPrice() + "'><br>");
		out.print("<button type='submit'>수정</button> <button type='reset'>취소</button>");
		out.print("</form>");
		out.print("<br><br><a href=\"index.html\">메인으로</a>");
		out.print("</body>");
		out.print("</html>");
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
