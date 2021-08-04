<%@page import="util.CookieBox"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.addCookie(CookieBox.makeCookie(" name", "이강인"));
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

	<!-- 쿠키 이름으로 이름, 값, 객체 가져오기 -->
	
	<h3><a href="editCookie.jsp">쿠키 수정</a></h3>
	<h3><a href="deleteCookie.jsp">쿠키 삭제</a></h3>

</body>
</html>