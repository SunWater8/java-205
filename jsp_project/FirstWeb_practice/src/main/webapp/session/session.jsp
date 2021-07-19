<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.setAttribute("userName", "evanDrake");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션에 사용자 이름을 저장했습니다. : <%= session.getAttribute("userName") %></h1>
	<h3><a href="sessionView.jsp">세션의 속성 정보 확인</a></h3>
</body>
</html>