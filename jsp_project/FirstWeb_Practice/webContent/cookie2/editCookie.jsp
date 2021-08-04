<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	CookieBox cBox= new CookieBox(request);
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
		if(cBox.getValue("name") == "손흥민"){
			/* response.addCookie(cBox.makeCookie("name", "손흥민", "/", 0)); */
			response.addCookie(CookieBox.makeCookie("name", "이강인", "/", 60*60*24));
			//response.addCookie(CookieBox.makeCookie("name", ""))
		}
	
	
	%>
	<h4><a href="viewCookie.jsp">쿠키 보기</a></h4>
	
</body>
</html>