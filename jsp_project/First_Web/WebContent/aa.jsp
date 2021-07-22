<!-- 액션태그 forward -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>AAA</h1>

</body>
</html>
<!-- 실행하면 다른 페이지인 bb페이지가 보여진다. -->
<%-- <jsp:forward page="bb.jsp"/> --%>

<jsp:forward page="footer.jsp">
	<jsp:param name="email" value="test@gmail.com" />
	<jsp:param name="tel" value="010-0000-9999" />
</jsp:forward> 