<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   	session.setAttribute("userName","손흥민"); //손흥민이 들어가는 자리는 object 이지만 다형성 때문에 문자열도 가능함.
   %>
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
	<%-- <h1>세션에 사용자 이름을 저장했습니다. : <%= session.getAttribute("userName") %></h1>  el 학습 후 밑 문장으로 개선--%>
	<h1>세션에 사용자 이름을 저장했습니다. : <%= session.getAttribute("userName")%> / ${userName}</h1>
	<!-- 다른 서블릿을 가더라도 이 문서를 볼 수 있을까 -->
	<h3><a href="sessionView.jsp">세션의 속성 정보 확인</a></h3>

</body>
</html>