<!-- 0716(1) -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
<!-- 01. html을 작성해 보고 자바파일로 만들어 보기. (run as 눌러서 실행하면 자동으로 .java와 .class 가 알아서 만들어 짐. 
.java 파일을 확인해 보면 여기에 입력된 것들이 모두 메소드 안에 들어가 있는 것을 알 수있다. -->
	<%
		String name = "SON";
	%>
	안녕하세요 <%= name %>
	
	<!-- 02. hello_jsp.java 파일 안에 있는 변수, 메소드를 사용할 수 있다. 이런 변수를 jsp에서 사용할 수 있는 내장객체 기본변수라고 한다. -->
	<%= request.getContextPath() %>
</body>
</html>