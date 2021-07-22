<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    /* 배열 타입으로 쿠키 받기 */
    CookieBox cBox = new CookieBox(request);
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
	name = <%= cBox.getValue("name") %><br>
	number = <%= cBox.getValue("number1") %><br>
	age = <%= cBox.getValue("age") %><br>

	<a href="editCookie.jsp">쿠키 수정</a>
	<a href="deleteCookie.jsp">쿠키 삭제</a>
</body>
</html>