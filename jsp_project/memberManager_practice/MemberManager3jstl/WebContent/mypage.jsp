<%@page import="domain.LoginInfo"%>
<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  		//개선1. toLoginInfo 메소드 생성 후 수정되었기에 주석처리
    	//Member member = (Member) session.getAttribute("member");
    
  		//toLoginInfo 메소드 생성 후 코드 개선
  		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
    	//getAttribute메소드는 객체를 반환하기 때문에 member라는 형변환이 필요하다.
    
    	//개선2. toLoginInfo 메소드 생성 후 수정되었기에 주석처리
    	//if(member == null){ //로그인이 안 되었을 때 이 페이지는 사용할 수 없고, 
    		
    	//toLoginInfo 메소드 생성 후 코드 개선
    	if(loginInfo == null){
    		%>
    		
    	<script>
    		alert('로그인이 필요한 페이지 입니다. \n 로그인 후 사용해 주세요!');
    		location.href='<%=request.getContextPath()%>/loginForm.jsp';
    	</script>
    		
    		<%
    	}else{
    		
    	
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
	
		<h2>my page</h2>
		<hr>
		<h3>
		<!-- 개선3. toLoginInfo 메소드 생성 후 수정되었기에 주석처리 -->
		<%-- 	<%= member %> --%>
		<!-- //toLoginInfo 메소드 생성 후 코드 개선 -->
			${loginInfo }
		</h3>
		
	
	</div>


</body>
</html>
<%}%>