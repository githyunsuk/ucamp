<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비빌번호 변경 페이지</h1><hr>
<form method="post" action="/member/changepwd">
새 비밀번호 입력 : <input type="password" name="password"><br>
<button type="submit">변경</button> <button type="reset">취소</button><br>
</form>
<a href="/member">회원 페이지로 이동</a>
<a href="/logout">로그아웃</a>
</body>
</html>