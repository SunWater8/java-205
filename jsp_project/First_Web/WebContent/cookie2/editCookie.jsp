<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //쿠키의 수정은 같은 이름의 쿠키를 만들어서 설정하면 된다.
    //새롭게 만드는 쿠키를 생성 -> response 이용
    response.addCookie(CookieBox.makeCookie("name", "이강인"));
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
	<h1> 쿠키 값이 변경되었습니다.</h1>
	<a href="viewCookie.jsp"> 쿠키 보기</a>
	
	
</body>
</html>