<!-- jsp가 view의 역할만 하기(데이터를 속성으로 받아서 출력해주는 역할) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String[] players = (String[])request.getAttribute("players");
%>
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
	<!-- 배열을 받아 출력하기 -->
	<h1>선수 list</h1>
	<%
		for(int i=0; i<players.length; i++){
			out.println(players[i]+"<br>");
		}
	%>
</body>
</html>