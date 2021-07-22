<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //쿠키의 삭제 : 쿠키 유지시간을 0으로 설정한다.
    Cookie c = new Cookie("cname", ""); //공백으로 처리해도 된다.
    //c.setMaxAge(60*60*24*7); //초*분*시간*일자. 일주일동안 보이지 않게 하기
    c.setMaxAge(0);
    response.addCookie(c);
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
	<h1>쿠키가 삭제되었습니다.</h1>
	<a href="viewCookie.jsp"> 쿠키 보기</a>
</body>
</html>