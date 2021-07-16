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
<!-- include의 특징 : 실행된 jsp 결과를 html(text)로 가져온다. -->
	<jsp:include page="footer.jsp">
		<jsp:param name="email" value="test@gmail.com"/>
		<jsp:param name="tel" value="010-0000-0000"/>
	</jsp:include>

</body>
</html>