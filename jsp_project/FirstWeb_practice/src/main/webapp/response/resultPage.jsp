<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result page</title>
<style>
</style>
<script>
	
</script>
</head>
<body>
	<%
	String select = request.getParameter("select");
	int selNum = Integer.parseInt(select);
	if(selNum>0){
		out.println(selNum);
		response.sendRedirect("result.jsp");
	}else{
		out.println(selNum);
		%>
			<jsp:forward page="result.jsp"/>
		<%
	}
	%>
</body>
</html>