<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="/login" method="post">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="password"><br>	
<button type="submit">로그인</button><button type="reset">취소</button>
</form>
<h1>회원가입</h1>
<form action="/register" method="post">
아이디 : <input type="text" name="id"><br>
이름 : <input type="text" name="name"><br>
비밀번호 : <input type="password" name="password"><br>	
<button type="submit">회원가입</button><button type="reset">취소</button>
</form>
</body>
</html>