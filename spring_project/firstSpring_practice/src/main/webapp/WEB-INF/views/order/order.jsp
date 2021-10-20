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

<%-- ${orderCommand} --%>


	<h1>주문</h1>
	<hr>
		<table border="1">
		
		<c:forEach items="${orderCommand.orderItems}" var="item" varStatus="stat">
		<!-- items는 원본, orderCommand는 생성된 객체, orderItems는 상품의 리스트 객체 - orderCommand객체의 상품들 모음객체를 원본으로 하고, 이 원본을 item이라고 이름을 붙인다.
		카운트를 하기 위해 stat 사용하기 -->
			<tr>
				<td rowspan="3">상품-${stat.count}</td>
				<td>ID</td>
				<td> ${item.itemId} </td>
			</tr>
			<tr>
				<td>수량</td>
				<td> ${item.number} </td>
			</tr>
			<tr> 
				<td>주의</td>
				<td> ${item.remark} </td>
			</tr>
			
		</c:forEach>
			
			<tr>
				<td rowspan="3">주소</td>
				<td>우편번호</td>
				<td> ${orderCommand.address.zipcode} </td>
			</tr> 			
			<tr>
				<td>주소1</td>
				<td> ${orderCommand.address.address1} </td>
			</tr>			
			<tr>
				<td>주소2</td>
				<td> ${orderCommand.address.address2} </td>
			</tr>
		
			
		</table>
	


</body>
</html>

<!-- 
해야하는 것:
1. Controller : 사용자 요청 URL 등록 -> view 지정하기
2. view 생성 -->



