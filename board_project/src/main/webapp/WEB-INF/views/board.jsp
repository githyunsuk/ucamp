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
	<h1>게시판 페이지</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
		</tr>
		<c:forEach var="board" items="${list}" varStatus="i">
		<tr>
			<td>${i.count}</td>	
			<td>${board.title}</td>	
			<td>${board.content}</td>
			<td>${board.name}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="/writeForm"><button>작성하기</button></a><br>
	<a href="/logout">로그아웃</a>
</body>
</html>