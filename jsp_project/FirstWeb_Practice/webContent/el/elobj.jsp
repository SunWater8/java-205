<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setAttribute("name", "손흥민");
    session.setAttribute("name","이강인");
    application.setAttribute("name","Messi");
    %>
    
    <%
    Member member = new Member();
    member.setId("cool");
    member.setPw("12345");
    member.setName("CoolName");
    session.setAttribute("member", member);
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
	표현식 : <%=request.getAttribute("name") %> <br>
	표현언어1 : ${requestScope.name} <br>
	표현언어2 : ${name} <br>
	표현언어3 : ${sessionScope.name }<br>
	표현언어4 : ${applicationScope.name }<br>
	
	<hr>
	<!-- 언제 사용하는지는 모르겠음. -->
	param.code : <%=request.getParameter("code") %> <br>
	param.code : ${param.code}
	
	<hr>
	
	pageContext : <%= pageContext.getRequest().getServletContext().getContextPath()%><br>
	${pageContext.request.requestURL }<br>
	${pageContext.request.requestURI }<br>
	${pageContext.request.contextPath }
	
	<hr>
	
	${true } <br>
	${false } <br>
	${100 } <br>
	${null }<br>
	<!--  -->
	
	<hr>
	
	${member } <br>
	<%=session.getAttribute("member") %><br>
	
	${member.id }<br>
	<%=((Member)session.getAttribute("member")).getId() %><br>
	
	
</body>
</html>