<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not loginChk}">
	<script>
		alert('아이디 혹은 비밀번호를 잘못 입력하였습니다.');
		history.go(-1);
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
</head>
<body>
<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<div id="content">

		<h2>Login</h2>
		<hr>
		<h2> ${loginInfo} </h2>
			

	</div>
</body>
</html>