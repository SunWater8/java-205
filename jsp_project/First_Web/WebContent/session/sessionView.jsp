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
	<%
	//로그인 후 사용자(회원)의 이름을 세션 속성에 저장
	String userName = (String) session.getAttribute("userName"); //getAttribute의 반환 타입은 object 이기 때문에 string형 변환이 필요. session.jsp에서 setAttribute에 저장된 것은 String 문자열이기 때문이다.

	if (userName == null) {
		out.println("<script>alert('로그인이 필요한 상태입니다.')</script>");
	}
	%>
	<h1>세션의 속성에 저장된 userName : <%=session.getAttribute("userName")%></h1>
	<h3><a href="logout.jsp">로그아웃</a></h3>
</body>
</html>