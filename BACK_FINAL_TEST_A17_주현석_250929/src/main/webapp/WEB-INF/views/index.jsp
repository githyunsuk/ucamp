<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1><hr>
<form action="loginProc" method="post">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="password"><br>
<button type="submit">입력</button> <button type="reset">취소</button>
<c:if test="${msg != null}">
<h3>${msg}</h3>
</c:if>
</html>