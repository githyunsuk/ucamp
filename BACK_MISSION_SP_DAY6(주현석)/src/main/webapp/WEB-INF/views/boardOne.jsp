<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board Detail Page</h1>
<form action="boardOne">
No 입력: <input type="text" name="no">
<button type="submit">입력</button> <button type="reset">취소</button>
</form>
<c:if test="${not empty board}">
No : ${board.no}<br>
작성자 : ${board.writer}<br>
내용 : ${board.content}<br>
</c:if>
<a href="index">메인으로</a>
</body>
</html>