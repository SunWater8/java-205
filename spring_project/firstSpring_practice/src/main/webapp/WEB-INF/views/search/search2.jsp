<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 화면</title>
</head>
<body>

	<h1>검색</h1>
	<hr>
	<select>
		<c:forEach items = "${searchTypeList}" var = "searchType">
			<option value = "${searchType.value }">${searchType.label }</option>
		</c:forEach>
	</select>
	<input> <input type="submit">
</body>
</html>