<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Hello_Spring_Web/deleteProc" method="post">
<label>아이디</label> <input type="text" name="id" readonly="readonly" value="${id}"><br>
<button type="submit">삭제</button> <button type="reset">취소</button>
<br><br>
</form>
<a href="/Hello_Spring_Web/manager">관리 메인으로</a>
</body>
</html>