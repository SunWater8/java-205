<!-- error page -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 에러가 났을 때 보여질 페이지로 등록 -->
    <%@ page isErrorPage="true" %> 
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
<!-- 안내 메시지 -->
	<h1>NullPointerException 에러가 발생했습니다. 
	<br>메인 페이지로 이동해 주세요.</h1>
	<h3>
		<%= exception.getMessage() %> <br>
		<%= exception.getClass().getName() %> 
	</h3>
</body>
</html>