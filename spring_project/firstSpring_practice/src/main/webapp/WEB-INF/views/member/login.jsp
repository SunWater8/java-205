<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Data</title>
<style>
</style>
<script>
	
</script>
</head>
<body>
	<h1>Login Request Data</h1>
	<hr>
	<table>
		<tr>
			<td>아이디</td>
			<td>id : ${id}, uid : ${uid} , loginRequest : ${loginReq.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${pw}, ${upw} , ${loginReq.pw}</td>
		</tr>

	</table>
</body>
</html>