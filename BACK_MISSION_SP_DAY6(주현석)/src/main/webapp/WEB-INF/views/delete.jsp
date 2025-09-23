<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Delete Page</h1>
<hr>
<form action="deleteProc">
NO: <input type="text" name="no">
<button type="submit">입력</button> <button type="reset">취소</button>
<br><br>
</form>
<c:if test="${not empty msg}">
    <c:choose>
        <c:when test="${msg == 'success'}">
            <h2>성공!</h2>
        </c:when>
        <c:otherwise>
            <h2>실패!</h2>
        </c:otherwise>
    </c:choose>
</c:if>
<a href="index">메인으로</a>
</body>
</html>