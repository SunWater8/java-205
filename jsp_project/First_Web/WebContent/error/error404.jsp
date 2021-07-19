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
	<h1>요청하신 페이지가 존재하지 않습니다. <br>
	다시 확인하시고 요청해 주세요.</h1>
	<h3>
		<%= exception.getMessage() %> <br>
		<%= exception.getClass().getName() %> 
	</h3>
</body>
</html>