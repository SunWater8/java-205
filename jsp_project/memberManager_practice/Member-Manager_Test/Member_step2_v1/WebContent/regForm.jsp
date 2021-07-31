<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">
<style>
</style>
<script>
	
</script>
</head>
<body>

	<%@ include file="/WEB-INF/frame/header.jsp"%>
	<%@ include file="/WEB-INF/frame/nav.jsp"%>

	<div class="contents">

		<h2>회원 정보 등록</h2>
		<hr>

		<form action="regMem.jsp" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" ></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" ></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" ></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="가입"> 
					<input type="reset"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>