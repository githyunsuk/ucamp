<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 작성 페이지</h1>
<form action="/write" method="post">
제목 : <input type="text" name="title"> 이름 : ${name}
</form>
</body>
</html>