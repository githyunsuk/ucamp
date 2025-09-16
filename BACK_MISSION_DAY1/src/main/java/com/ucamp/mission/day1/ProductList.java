package com.ucamp.mission.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static ArrayList<Product> PRODUCT_LIST = new ArrayList<Product>();
	
    public ProductList() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int num = 0;
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>제품 목록</h1><hr>");
		out.print("<table border='1'>");
		out.print("<tr><th>NO</th><th>제품 번호</th><th>제품 이름</th><th>제품 가격</th><th></th><th></th></tr>");
		
		if(PRODUCT_LIST.size() > 0 ) {
			for(Product product : PRODUCT_LIST) {
				out.print("<tr>");
				out.print("<td>" + ++num + "</td>");
				out.print("<td>" + product.getNo()+ "</td>");
				out.print("<td>" + product.getName() + "</td>");
				out.print("<td>" + product.getPrice() + "</td>");
				out.print("<td><a href='UpdateForm?no=" + product.getNo() + "'>수정</a></td>");
				out.print("<td><a href='DeleteForm?no=" + product.getNo() + "'>삭제</a></td>");
				out.print("</tr>");
			}
		} else {
			out.print("<tr><td colspan='6'>제품 목록이 비었습니다</td></tr>");
		}
		out.print("</table>");
		out.print("<br><a href=\"index.html\">메인으로</a>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
