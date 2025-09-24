<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Hello_Spring_Web/updateProc" method="post">
		<label>아이디</label> <input type="text" name="id" readonly="readonly" value="${employee.id}"><br> 
		<label>이름</label><input type="text" name="name" value="${employee.name}"><br> 
		<label>비밀번호</label><input type="password" name="password" value="${employee.password}"><br> 
		<label>부서</label><input type="text" name="dname" value="${employee.dname}"><br>
		<button type="submit">수정</button><button type="reset">취소</button>
		<br><br>
	</form>
	<a href="/Hello_Spring_Web/manager">관리 메인으로</a>
</body>
</html>