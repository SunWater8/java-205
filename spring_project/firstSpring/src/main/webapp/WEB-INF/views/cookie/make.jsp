<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- annotation으로 만든 쿠키를 가져오기 -->

	<!-- http://localhost:8080/mvc/cookie/make 이 경로로 사용자가 들어왔을 때 보는 화면-->
	
	<h1>쿠키가 생성되었습니다</h1>
	<a href="<c:url value='/'/>">홈으로 가기</a><br>
	<!-- index (홈)으로 가는 경로로 이동해주기 -->
	
	<a href="view">쿠키 정보 보기</a>
</body>
</html>