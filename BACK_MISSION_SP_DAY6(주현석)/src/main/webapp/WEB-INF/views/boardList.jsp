<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board List Page</h1>
<table border="1">
	<tr>
		<th>NO</th>
		<th>작성자</th>
		<th>내용</th>
	</tr>
	<c:forEach var="board" items="${boardList}">
	<tr>
		<td>${board.no}</td>
		<td>${board.writer}</td>
		<td>${board.content}</td>
	</tr>
	</c:forEach>
</table>
<a href="index">메인으로</a>
</body>
</html>