<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   request.setAttribute("name", "손흥민");
   session.setAttribute("name", "이강인");
   application.setAttribute("name", "messi");
   
 	Member member = new Member();
 	member.setId("cool");
 	member.setName("COOL");
 	member.setPw("1234");
 	session.setAttribute("member", member);
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- name 출력하기 -->
	
	<span>표현식 : <%= request.getAttribute("name") %> </span> <br>
	
	<span>표현언어1 : ${requestScope.name}</span><br><br>
	
	내장객체의 표현식이 생략되었을 때 규칙<br>
	속성 찾는 순서 <br>
	1. pageScope -> 
	2. requestScope -> 
	3. sessionScope -> 
	4. applicationScope <br><br>
	
	<span>표현언어2 : ${name}</span><br> <!-- name 앞에 속성을 지정하지 않으니, 이강인이 뜨지 않음 -->
	<span>표현언어3 : ${sessionScope.name}</span><br> <!-- 이강인 뜸. -->
	<span>표현언어4 : ${applicationScope.name}</span><br> <!-- messi가 출력 -->
	
	<hr>
	param.code : <%= request.getParameter("code")%> <br>  <!-- null이 출력 -->
	param.code : ${param.code}  <!-- 아무것도 나오지 않음. 오류 메시지도 나오지 않기 때문에 어떤 문제인지 알수가 없다. -->
	
	<hr>
	<!-- context 경로 출력하기 -->
	pageContext : <%=pageContext.getRequest().getServletContext().getContextPath() %>
	<br><br>
	%{pageContext.request.requestURL}<br>
	${pageContext.request.requestURI}<br>
	${pageContext.request.contextPath}<br>
	
	<hr>
	${true} / ${false} / ${100} / ${'손흥민'} / ${null} <!-- null이 들어오면 아무것도 출력되지 않는다. -->

    <!-- member 객체 이용 -->
	<hr>
	${member }	
	
	<br> 이전 방식<br>
	<%=session.getAttribute("member") %>
	
	
	<br> 아이디 값을 호출<br>
	${member } / ${member.id }
	<!-- member.id는 member.getId() 이렇게 get 메소드를 호출하는 거와 같다. -->
	<br> 이전 방식<br> <!-- Member 로 형변환 하기 -->
	<%=session.getAttribute("member") %> / <%=((Member) session.getAttribute("member")).getId() %>
	
</body>
</html>