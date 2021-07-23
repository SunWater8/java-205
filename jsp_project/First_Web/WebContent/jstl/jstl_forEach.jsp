<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
span{
color:red;
}
</style>
<script>
	
</script>
</head>
<body>

	${members}
	<h1>회원 리스트</h1>
	<table border=1>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>index</td>
			<td>count</td>
		</tr>

		<c:forEach items="${members}" var="member" varStatus="stat">

		<tr>
			<td>${member.id}</td>
			<td>%{member.pw}</td>
			<%-- <td>${member.name}</td>   아래처럼 수정 --%>
			<td>
				<c:out value="${member.name}" escapeXml="false">
				<span>등록된 정보가 없습니다.</span>
				</c:out>
			</td>
			<td>${stat.index}</td>
			<td>${stat.count}</td>
			
		</tr>
		</c:forEach>
	</table>
	
	<hr>
	<h1>숫자 5번 반복</h1>
	<c:forEach var="number" begin="1" end="5" step="1">
		<h3>${number}</h3>
	</c:forEach>
	
	
	<hr>
	<!-- forTokens : delims에 대입되는 문자를 기준으로 개행해줌.
					 다음은 ,를 기준으로 개행함. -->
	
	<c:forTokens items="손흥민, 010-0000-9999, 런던" delims="," var="str">
		${str }<br>
	</c:forTokens>
	

	<c:forTokens items="손흥민, 010-0000-9999, 런던" delims="," var="str" varStatus="stat">
		<!-- stat의 1번째 요소인 전화번호를 가지고 텍스트박스 만들기  -->
		<c:if test="${stat.index == 1 }">
			<input type="text" value="${str}">
		</c:if>
		
	</c:forTokens>
</body>
</html>