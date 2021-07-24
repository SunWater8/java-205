<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	/* Cookie[] cookies = request.getCookies(); */
	Cookie c = new Cookie("age", "20");
	response.addCookie(c);
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
<%
/* 	
if(cookies != null && cookies.length>0){
		for(int i=0; i<cookies.length;i++){
			if(cookies[i].getName().equals("age")){
				Cookie cookie = new Cookie("age","10");
				response.addCookie(cookie);
				out.println("쿠키값이 변경되었습니다.");
			}
		}
	}
*/

%>
<h3> 쿠키가 변경되었습니다. </h3>
<a href="viewCookie.jsp">쿠키 보러 가기</a>
	
</body>
</html>