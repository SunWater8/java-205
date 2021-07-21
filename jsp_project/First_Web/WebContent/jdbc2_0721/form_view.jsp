<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>부서 정보 수정</h1>
	<hr>

	<form action="editDept.jsp" method="post">
		<table>
			<tr>
				<td>부서번호</td>
				<!-- 부서번호는 pk 이기 때문에 읽기만 가능 -->
				<td><input type="number" name="deptno" value="<%= deptno%>"readonly></td>
				<!-- required : 빈칸 없음 -->
			</tr>
			<tr>
				<td>부서이름</td>
				<td><input type="text" name="dname" value="<%= dept.getDname() %>" required></td>
			</tr>
			<tr>
				<td>부서위치</td>
				<td><input type="text" name="loc" <%=dept.getLoc() %>required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="등록"> 
				<input type="reset" value="초기화"></td>
			</tr>
		</table>
	</form>
</body>
</html>