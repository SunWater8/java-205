<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>검색</h1>
	<h3>
		최근 관심 검색어 : 
		
		<!-- 인기검색어 나열 할 때 문자열로 된 배열을  반복문을 통해서 출력하기 -->
		<c:forEach items="${queryList}" var="query">
		${query}
		</c:forEach>
	</h3>
	
	<select>
		<c:forEach items="${searchTypeList}" var="searchType">
		<option value="${searchType.value}"> ${searchType.label} </option>
		<!-- searchType.value에서 value는 getValue 라는 것! 잊지 말기. -->
		</c:forEach>
	</select>
	<input> <input type="submit">
	
	

</body>
</html>