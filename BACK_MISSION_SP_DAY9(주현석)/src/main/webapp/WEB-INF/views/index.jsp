<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Spring JPA Shop(Back_MISSION_SP_DAY9)</h1>
	<hr />
	<h3>아래 요구 사항에 맞게 애플리케이션을 구현하시오.</h3>
	<p>상품 주문을 위한 화면은 UI를 Form으로 구현(현재 화면)합니다.</p>
	<hr />
	<h3>구매(상품 주문)(TBL_ORDER 테이블에 입력)</h3>
	<form action="/order" method="post">
	<label>유저 ID</label><input type="text" name="userid"><br>
	<label>상품명</label><input type="text" name="pname"><br>
	<label>수량</label><input type="text" name="ordercount"><br>
	<button type="submit">입력</button>
	</form>
	<hr />
	<h3>상품 입력</h3>
	<h3><a href="/product">전체 상품 조회</a></h3>
	<h3>아이디로 상품 조회</h3>
	<h3>아이디로 상품 수정</h3>
	<hr />
	<h3><a href="/order">전체 주문 조회</a></h3>
	<h3>고객 아이디로 주문 조회</h3>
</body>
</html>