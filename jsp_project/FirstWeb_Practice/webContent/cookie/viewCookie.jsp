<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
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
	if(cookies != null && cookies.length>0){
		for(int i=0; i<cookies.length; i++){
			String name = cookies[i].getName();
			String val = cookies[i].getValue();
			/* if(name.equals("age")){
			out.println("<h4>"+name+" : "+val+"</h4>");
			} */
			out.println("<h4>"+name+" : "+val+"</h4>");
		}
	}else{
		out.print("쿠키가 존재하지 않습니다.");
	}
	

%>
	<a href ="editCookie.jsp">쿠키 수정 - age를 7 -> 20 변경</a>
	<a href ="deleteCookie.jsp">쿠키 삭제 - age 삭제</a>
	
</body>
</html>