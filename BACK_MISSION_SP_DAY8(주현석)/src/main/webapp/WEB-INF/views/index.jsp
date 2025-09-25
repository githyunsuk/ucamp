<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Spring Boot Rest App</h1>
<a href="/product">전체 상품 목록 조회(/product -> GET) -> JSON</a><br>
<a href="/product/2">카테고리별 상품 정보 조회(/product/{cid} -> GET) -> JSON</a><br>
<a href="/product/item/P1">개별 상품 조회(/product/item/{pid} -> GET) -> JSON</a><br><br>

<a href="/product">상품 정보 입력(/product -> POST): PostMan으로 체크 -> JSON</a><br>
<a href="#">상품 정보 수정(/product/item/{pid} -> PUT): PostMan으로 체크 -> JSON</a><br>
<a href="#">상품 정보 삭제(/product/item/{pid} -> DELETE): PostMan으로 체크 -> JSON</a><br>
</body>
</html>