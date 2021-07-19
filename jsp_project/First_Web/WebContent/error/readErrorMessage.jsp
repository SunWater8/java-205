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
	<h1>에러가 발생했습니다. 메인 페이지로 이동해 주세요.</h1>
	<h3>
		<%= exception.getMessage() %> <br>
		<!-- 클래스 이름 가져오기 -->
		<%= exception.getClass().getName() %> 
		<%= exception.getClass().getName().equals("java.lang.ArithmeticException") %> 
	</h3>
	<p>
	<!-- 예외가 발생한 사유 출력하기 - 실제에선 사용하지 않음. 지금은 확인용. -->
		<% exception.printStackTrace(); %> 
	</p>
</body>
</html>