<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="content">

		<h2>Login</h2>
		<hr>
		<form method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="memberid" value="${cookie.reid.value}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="reid" value="on" ${cookie.reid ne null? 'checked':''}> 아이디 기억하기
					<input type="hidden" name="redirectUri" value="${redirectUri ne null ? redirectUri : '' }">
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>