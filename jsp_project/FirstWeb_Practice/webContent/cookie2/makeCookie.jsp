<%@page import="util.CookieBox"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	response.addCookie(CookieBox.makeCookie("name", "손흥민", "/", 60*60*24)); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>makeCookie. 쿠키 생성</title>
</head>
<body>
	<h3> 쿠키 생성</h3>
	<a href="viewCookie.jsp">쿠키 보기</a>
</body>
</html>