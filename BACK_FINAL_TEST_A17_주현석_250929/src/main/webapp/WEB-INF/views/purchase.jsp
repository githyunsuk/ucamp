<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>주문 페이지</h1>
상품명 : ${product.name}<br>
가격 : ${product.price}<br>
설명 : ${product.description}<br>
<form action="/purchase/${product.productId}" method="post">
<button type="submit">구매</button> <button type="reset">취소</button>
</form> 
<a href="/member">회원화면</a>
</body>
</html>