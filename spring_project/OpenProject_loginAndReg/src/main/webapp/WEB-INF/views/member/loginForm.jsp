<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 로그인</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
</head>
<body>
	
<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>

	<div id="content">

		<h2>Login</h2>
		<hr>

		<form method="post">

			<table>
				<tr>
					<th>ID</th>
					<%--=reid--%>
					<td><input type="text" name="memberid"
						value="${cookie.reid.value}"> <!-- 저장된 쿠키 값 가져오기(아이디 저장하기를 누른 상태였다면 저장된 쿠키가 적용 됨. -->
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th></th>
					<%--=checked--%>
					<td><input type="checkbox" name="reid" value="on"
						${cookie.reid ne null ? 'checked' : ''}> 아이디 기억하기
						
						<input type="hidden" name="redirectUri" value="${redirectUri ne null ? redirectUri : '' }">
						</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit"></td>
				</tr>
			</table>

		</form>
	</div>


</body>
</html>