<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
   
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
	<h1>
	<!-- 슬래시를 넣으면 context 경로가 나온다. -->
	<c:url value="/index.jsp" var="urlIndex"/>
	${urlIndex }
	
	<br>
	<!-- 슬래시가 없으니 상대 경로가 나온다. -->
	<c:url value="index.jsp" var="urlIndex"/>
	${urlIndex }
	
	<br>
	<!-- 변수가 없으면 그냥 그대로 출력이 된다. -->
	<c:url value="index.jsp" />
	${urlIndex }
	
	<br>
	<!-- a태그안에 넣기 -->
	<a href="<c:url value="/index.jsp" />">홈으로 가기</a>
	
	<br>
	
	<c:url value="/index.jsp" var = "homeUrl">
		<c:param name="type">main</c:param>
		<c:param name="index">1</c:param>
	</c:url>
	${homeUrl}
	
	<br>
	<a href="${homeUrl}">${homeUrl}</a>
	
	<br>
	<c:url value="/index.jsp" var = "homeUrl">
		<c:param name="type" value="sub"/>
		<c:param name="index">1</c:param>
	</c:url>
	${homeUrl}
	
	</h1>
	
</body>
</html>