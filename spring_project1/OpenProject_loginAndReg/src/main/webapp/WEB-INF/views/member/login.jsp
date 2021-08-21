<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%--  <c:if test="${loginInfo eq null }"> //loginInfo 가 null이면 아이디와 비밀번호 일치하지 않다는 메시지 출력 --%>
   <!-- 위와 같은 문장 . 로그인 되었을 때 loginChk는 true가 된다. -->
	<c:if test="${not loginChk}"> 
	    <script>
		    alert('아이디와 비밀번호가 일치하지 않습니다.');
		    history.go(-1);
	    </script>
	    
    </c:if>

 <c:if test="${loginChk}">   <!-- 로그인 되었을 때 보여주는 화면 --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 로그인</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
</head>
<body>
	
<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>

	<div id="content">

		<h2>Login</h2>
		<hr>
		<h2> ${loginInfo} </h2>
			

	</div>


</body>
</html>
</c:if>ㅋ