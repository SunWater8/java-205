<%@page import="member.Member"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   request.setAttribute("name", "손흥민");
   session.setAttribute("name", "이강인");
   application.setAttribute("name", "messi");
   /* 여기서 세 문장들의 name은 저장되는 위치가 다르기 때문에 중복으로 보지 않는다. */
   
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
	
	<!-- 보통은 주로 식별할 수 있는 이름을 사용해서 생략해서 씀. -->
	<span>표현언어2 : ${name}</span><br> <!-- name 앞에 속성을 지정하지 않으니, requestScope 인 손흥민을 출력 -->
	<span>표현언어3 : ${sessionScope.name}</span><br> <!-- sessionScope인 이강인 뜸. -->
	<span>표현언어4 : ${applicationScope.name}</span><br> <!-- applicationScope인 messi가 출력 -->
	
	<hr>
	param.code : <%= request.getParameter("code")%> <br>  <!-- 값이 없을 때 null이 출력 - el보다는 직관적.-->
	param.code : ${param.code}  <!-- 값이 없을 때 아무것도 나오지 않음. 오류 메시지도 나오지 않기 때문에 어떤 문제인지 알수가 없다. -->
	
	<hr>
	<!-- context 경로 출력하기 -->
	pageContext : <%=pageContext.getRequest().getServletContext().getContextPath() %>
	<br><br>
	${pageContext.request.requestURL}<br> <!-- URL : 전체 주소(web address) - 프로토콜, IP, 포트, 상세경로 - Uniform Resource Locator -->
	${pageContext.request.requestURI}<br> <!-- URI : 프로젝트 이하 경로(통합 자원 식별자) - 프로젝트명, 서블릿 명(패키지, 파일명) - Uniform Resource Identifier-->
	${pageContext.request.contextPath}<br> <!-- context path : 프로젝트 명  -->
	
	<hr>
	${true} / ${false} / ${100} / ${'손흥민'} / ${null} 
	<!-- false, 숫자, 문자 모두 출력이 되지만 null이 들어오면 아무것도 출력되지 않는다. -->

    <!-- member 객체 이용 -->
	<hr>
	<b>member 객체 전체 출력</b><br>
	EL 방식 : ${member}	<br>
	전 방식 : <%=session.getAttribute("member") %><br><br>
	
	<b>아이디 값을 호출</b><br>
	EL 방식 : ${member} / ${member.id }<br>	<!-- member.id는 member.getId() 이렇게 get 메소드를 호출하는 거와 같다. -->
	전 방식 : <%=session.getAttribute("member") %> / <%=((Member) session.getAttribute("member")).getId() %>
	<!-- 기본적으로 getAttribute 메소드는 String을 반환하기 때문에 id값을 가져오기 위해서는 Member 로 형변환 하기 -->
	
</body>
</html>