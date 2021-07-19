<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	application.setAttribute("name", "king");
	application.setAttribute("age", 11); //11은 auto Boxing (object 타입에서 int 타입으로 자동 변환)
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
	<h1>application 속성에 데이터를 저장</h1>
	<h3><a href="attrView.jsp">application 속성 확인</a></h3>
</body>
</html>