<%@page import="util.CookieBox"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Cookie[] cookies = request.getCookies();
	CookieBox cbox = new CookieBox(request);

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

<!--  
이름으로 검색하여 객체를 보여주는 거 하기
이름으로 검색하여 이름을 가져오도록 하기
이름으로 검색해서 값을 가져오도록 하기
  -->
 	<h2> name의 쿠키가 있다면 true</h2>
 	<%=cbox.exist("name") %>
	<h2> name의 쿠키 객체 보기</h2>
	<%=cbox.getCookie("name")%>
 	<h2> name의 쿠키 값 보기</h2>
 	<%=cbox.getValue("name") %>
 	<hr>
 	
 	name = <%=cbox.getValue("name") %> <br>
 	age = <%=cbox.getValue("age") %><br>
 	local = <%=cbox.getValue("local") %> <br>
 <!-- 
	if(cookies != null && cookies.length>0){
		for(int i=0; i<cookies.length; i++){
			String name = cookies[i].getName();
			String val = cookies[i].getValue();
			 if(name.equals("age")){
			out.println("<h4>"+name+" : "+val+"</h4>");
			} 
			//out.println("<h4>"+name+" : "+val+"</h4>");//
		}
	}else{
		out.print("쿠키가 존재하지 않습니다.");
	}
	  -->


	<a href ="editCookie.jsp">쿠키 수정 - age를 7 -> 20 변경</a> <br>
	<a href ="deleteCookie.jsp">쿠키 삭제 - age 삭제</a>
	
</body>
</html>