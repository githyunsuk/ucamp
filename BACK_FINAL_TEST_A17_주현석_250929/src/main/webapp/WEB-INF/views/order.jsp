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
<h1>주문 목록</h1><hr>
<table border="1">
<tr>
	<th>주문번호
	<th>상품명
	<th>주문 금액
	<th>주문 취소
</tr>
<c:forEach var="order" items="${OrderList}" varStatus="i">
<tr>
	<td>${i.count}
	<td>${order.name}
	<td>${order.price}
	<td>
	<c:choose>
		<c:when test="${order.status == 'ORDERED'}">
			<a href="/order/cancel/${order.orderId}">취소</a>
		</c:when>
		<c:when test="${order.status == 'CANCELED'}">
			취소됨
		</c:when>
	</c:choose>
	</td>
</tr>
</c:forEach>
</table>
<a href="/member">회원화면</a>
</body>
</html>