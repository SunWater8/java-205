<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Cookie cookie = new Cookie("name", "test");
	response.addCookie(cookie);
	//쿠키 추가
	response.addCookie(new Cookie("age", "7"));
	response.addCookie(new Cookie("local", "london"));

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>makeCookie. 쿠키 생성</title>
</head>
<body>
	<h3> 쿠키 생성</h3>
	쿠키 이름 : <%=cookie.getName() %> <br>
	쿠키 값  : <%= cookie.getValue() %>
	
	<hr>
	<a href="viewCookie.jsp">쿠키 보기</a>
	
</body>
</html>