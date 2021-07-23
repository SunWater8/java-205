<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<select>
		<option ${param.sel == 'a'? 'selected':''}>a</option>
		<option ${param.sel == 'b'? 'selected':''}>b</option>
		<option ${param.sel == 'c'? 'selected':''}>c</option>
		<!-- ==를 eq라고 써도 무방 -->
	</select>

	<c:choose>
		<c:when test="${param.sel == 'a' }">
			<h3>a 를 선택했습니다.</h3>
		</c:when>
		
		<c:when test="${param.sel == 'b' }">
			<h3>b 를 선택했습니다.</h3>
		</c:when>
		
		<c:when test="${param.sel == 'c' }">
			<h3>c 를 선택했습니다.</h3>
		</c:when>
		
		<c:otherwise>
			a, b, c가 아닌 데이터를 선택했습니다.
		</c:otherwise>
	</c:choose>
	
	<c:set var="num" value="10"/>
	<br>
	
	${num }:
	<c:choose>
		<c:when test="${num>0 }">양수</c:when>
		<c:when test="${num<0 }">음수</c:when>
		<c:otherwise>0</c:otherwise>
	</c:choose>
</body>
</html>