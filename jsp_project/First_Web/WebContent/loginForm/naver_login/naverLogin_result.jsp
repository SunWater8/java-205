<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userid");
String userPw = request.getParameter("userpw");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 정보</h1>
	<table>
		<tr>
			<td>아이디</td>
			<td><%=userId %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=userPw %></td>
		</tr>
	</table>
</body>
</html>