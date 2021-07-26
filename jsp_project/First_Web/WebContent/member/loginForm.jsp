<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
<!DOCTYPE html >
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
	<h1>LoginForm</h1>
	<hr>
	<form action="<c:url value="/member/login.jsp"/>">
	<!-- /web/member/mypage/mypage.jsp 에서 mypage.jsp의 내용을 필터처리 하려고 하였으나, 여기의 form을 필터처리하게 되면 폼이 나오지 않고 login.jsp 로 forward 하게 된다? --> 
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	
	</form>
</body>
</html>