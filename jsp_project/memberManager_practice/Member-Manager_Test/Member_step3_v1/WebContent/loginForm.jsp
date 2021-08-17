<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/default.css">  
<style>
</style>
<script>
</script>
</head>
<body>

<%@ include file="/WEB-INF/frame/header.jsp" %>

<%@ include file="/WEB-INF/frame/nav.jsp" %>

	<div class="contents">
	
		<h2>Login</h2>
		<hr>
		<form action="login.jsp" method="post">
			<table border=1>
				<tr>
					<td>ID</td>
					<td><input type="text" name="memberid"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="reid">아이디 기억하기</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="로그인"></td>
				</tr>
			
			</table>
		</form>
	
	
	</div>


</body>
</html>