<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 2. 코어태그 만들기 -->
<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
/* 4. div에 스타일 주기 */
	div.message_box{
		padding : 5px;
		border : 1px solid #AAA;
		margin : 5px;
		width : 300px;
	}
	/* 6. 페이징에 스타일 주기 */
	div.paging{
		padding : 10px;
		margin-left : 10px;
		margin-bottom : 100px;
	}
</style>
<script>
	
</script>
</head>
<body>
<!-- 1. 방명록 table 생성 -->
	<form action="writemessage.jsp" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="guestname" required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>메시지</td>
				<td><textarea rows="10" cols="30" name="message"></textarea></td>
			<tr>
				<td></td>
				<td><input type="submit" value="메시지 남기기"></td>
			</tr>
			</tr>

		</table>
	</form>

	<hr>
<!-- 3. 작성 정보 -->
	<c:if
		test="${listView.messageList ne null and not empty listView.messageList}">
		<c:forEach items="${listView.messageList }" var="message">
			<div class="message_box">
				<table>
					<tr>
						<td>메시지 아이디</td>
						<td>${message.messageid}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${message.guestname }</td>
					</tr>
					<tr>
						<td>메시지</td>
						<td>${message.message }</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td>${message.regdate }</td>
					</tr>
					<!-- 7. 삭제 기능 -->
					<tr>
						<td></td>
						<td><a href="#">삭제</a></td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</c:if>

<!-- 5. 페이징 -->
	<c:if test="${listView.pageTotalCount>0}">
		<div class="paging">
			<c:forEach begin="1" end="${listView.pageTotalCount }" var="num"> <!-- count가 default로 1씩 증가함. -->
				<span>[<a href="list.jsp?page= ${num }"></a>]</span>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>
