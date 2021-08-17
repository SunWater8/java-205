<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //
    
    //현재 요청하는 쿠키 값을 저장해 놓고 쓸 수 있도록 하기
    CookieBox cBox = new CookieBox(request);
    //저장되어 있는 value 값을 가져오기. value는 사용자 아이디를 의미.
    //reid가 null일 때를 대비해 삼항연산자 사용
    String reid = cBox.exists("reid")? cBox.getValue("reid"):"";
    String checked = cBox.exists("reid")? "checked":"";
    %>
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
		<form action="login.jsp" method ="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="memberid" value="<%=reid%>"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="checkbox" name="reid" value="on" value="<%=checked%>">아이디 기억하기</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>


	</div>


</body>
</html>