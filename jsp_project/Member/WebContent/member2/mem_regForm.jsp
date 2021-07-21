<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>회원 정보 등록</h1>
	<hr>
	
	<form action="regMem.jsp" method="post">
		<table border=1>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" required></td>
			</tr>
			<tr>
				<td>비밀번호(확인)</td>
				<td><input type="password" required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="가입">
				<input type="reset"></td>
			</tr>

		</table>
	
	
	</form>
</body>
</html>