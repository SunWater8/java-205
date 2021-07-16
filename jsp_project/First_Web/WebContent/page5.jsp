<!-- 0716(3) 레이아웃 만들기 (inclode 지시어) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<%@ include file="include/header.jsp"%>
<hr>
	<%@ include file="include/nav.jsp"%>
<div id="wrap">
	<%@ include file="include/news.jsp"%>
	<%@ include file="include/shopping.jsp"%>
</div>

</body>
</html>