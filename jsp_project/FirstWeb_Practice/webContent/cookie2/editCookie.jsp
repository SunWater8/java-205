<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.addCookie(CookieBox.makeCookie("age", "12"));
	response.addCookie(CookieBox.makeCookie("name","이강인"));
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
<%


%>
<h3> 쿠키가 변경되었습니다. </h3>
<a href="viewCookie.jsp">쿠키 보러 가기</a>
	
</body>
</html>