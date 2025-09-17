<%@page import="com.ucamp.mission.day2.EmployeeDTO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
EmployeeDTO eDTO = null;

Connection conn;
PreparedStatement pstmt = null;
ResultSet rs = null;

Class.forName("oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "scott", "TIGER");

String sql = "SELECT id, name, password, dname FROM employee where id = ?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, id);
rs = pstmt.executeQuery();

if(rs.next()){
	eDTO = new EmployeeDTO();
	eDTO.setId(rs.getString("id"));
	eDTO.setName(rs.getString("name"));
	eDTO.setPassword(rs.getString("password"));
	eDTO.setDname(rs.getString("dname"));
}

pageContext.setAttribute("employee", eDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateProc">
		<label>아이디</label> <input type="text" name="id" readonly="readonly" value="${employee.id}"><br> 
		<label>이름</label><input type="text" name="name" value="${employee.name}"><br> 
		<label>비밀번호</label><input type="password" name="password" value="${employee.password}"><br> 
		<label>부서</label><input type="text" name="dname" value="${employee.dname}"><br>
		<button type="submit">수정</button><button type="reset">취소</button>
		<br><br>
	</form>
	<a href="manager.html">관리 메인으로</a>
</body>
</html>