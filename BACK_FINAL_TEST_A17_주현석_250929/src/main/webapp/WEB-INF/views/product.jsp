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
유저 : ${sessionScope.member.name} / <a href="/logout">로그아웃</a>
<h1>상품 목록</h1><hr>

<form action="/product" method="post">
<select name="option">
	<option value="id">상품명
	<option value="priceup">가격(이상)
	<option value="pricedown">가격(이하)
</select>
<input type="text" name="search">
<button type="submit">검색</button>
</form>

<table border="1">
<tr>
	<th>NO
	<th>제품 번호
	<th>제품 이름
	<th>제품 가격
	<th>구매
</tr>
<c:forEach var="product" items="${ProductList}" varStatus="i">
<tr>
	<td>${i.count}
	<td>${product.productId}
	<td>${product.name}
	<td>${product.price}
	<td><a href="/purchase/${product.productId}">구매</a>
</tr>
</c:forEach>
</table>
<a href="/member">회원화면</a>
</body>
</html>