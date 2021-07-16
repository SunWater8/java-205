<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userid");
String userPw = request.getParameter("userpw");
String userName = request.getParameter("username");
String birthYear = request.getParameter("birthyear");
String birthMonth = request.getParameter("birthmonth");
String birthDate = request.getParameter("birthdate");
String gender = request.getParameter("gender");
String email = request.getParameter("email");
String phoneNation = request.getParameter("phoneNation");
String phoneNum = request.getParameter("phonenum");
String inputNum = request.getParameter("inputnum");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>naver signup result</title>
</head>
<body>
	<h1>로그인 정보</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%=userId %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=userPw %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=userName %></td>
		</tr>
		<tr>
			<td>태어난 년도</td>
			<td><%=birthYear %></td>
		</tr>
		<tr>
			<td>태어난 달</td>
			<td><%=birthMonth %></td>
		</tr>
		<tr>
			<td>태어난 일</td>
			<td><%=birthDate %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=gender %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=email %></td>
		</tr>
		<tr>
			<td>전화 국가 번호</td>
			<td><%=phoneNation %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=phoneNum %></td>
		</tr>
		<tr>
			<td>인증번호 입력</td>
			<td><%=inputNum %></td>
		</tr>
	</table>
</body>
</html>