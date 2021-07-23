<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
  
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

<%	//현재시간
	request.setAttribute("now", new java.util.Date());
%>
	${now}
	<br><br>
	
	<%-- <fmt:timeZone value="hongkong"> 홍콩시간으로 다 바꾸어 줌. 닫는태그도 주석처리 봐야 함.--%>
	
	<fmt:formatDate value="${now }"/> <br>
	
	<h3>날짜 표현</h3>
	<fmt:formatDate value="${now }" type="date"/> <br>
	<fmt:formatDate value="${now }" type="date" dateStyle="full"/> <br>
	<fmt:formatDate value="${now }" type="date" dateStyle="short"/> <br>
	
	<h3>시간 표현</h3>
	<fmt:formatDate value="${now }" type="time"/> <br>
	<fmt:formatDate value="${now }" type="time" timeStyle="full"/> <br>
	<fmt:formatDate value="${now }" type="time" timeStyle="short"/> <br>

	<h3>both</h3>
	<fmt:formatDate value="${now }" type="both"/> <br>
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/> <br>
	<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/> <br>

	<h3>패턴</h3>
	<fmt:formatDate value="${now }" pattern="z a h:mm"/> <br>
	<fmt:formatDate value="${now }" pattern="hh:mm:ss"/> <br>
	<fmt:formatDate value="${now }" pattern="yyyy-MM-dd h:mm"/> <br> 
	<!-- 시간을 표현할 때 이미 mm을 썼기 때문에 달을 표현할 땐 대문자로 써야 한다. -->
	<fmt:formatDate value="${now }" pattern="yyyy.MM.dd. a h:mm"/> <br> 
	
	<!-- 홍콩 -->
	<fmt:formatDate value="${now }" pattern="yyyy.MM.dd. a h:mm" timeZone="hongkong"/> <br> 
	
	<%-- </fmt:timeZone> --%>
	


</body>
</html>