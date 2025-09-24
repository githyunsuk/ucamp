<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원 목록</h1><hr>
<table border="1">
	<tr>
		<th>NO</th>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>부서</th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach var="e" items="${list}" varStatus="i">
	<tr>
		<td>${i.count}</td>
		<td>${e.id}</td>
		<td>${e.name}</td>
		<td>${e.password}</td>
		<td>${e.dname}</td>
		<td><a href="/Hello_Spring_Web/update/${e.id}">수정</a></td>
		<td><a href="/Hello_Spring_Web/delete/${e.id}">삭제</a></td>
	</tr>
	</c:forEach>
</table>
<a href="/Hello_Spring_Web/manager">관리 메인으로</a>
</body>
</html>