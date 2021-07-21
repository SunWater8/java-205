 <%@page import="dept.domain.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Dept> list = (List<Dept>) request.getAttribute("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
td {
	text-align: center;
	padding: 5px 10px;
}

button {
	margin: 5px 0;
}
</style>
<script>
	
</script>
</head>
<body>
	<h1>부서 리스트</h1>
	<hr>

	<button onclick="location.href='dept_regForm.jsp';">부서 정보 등록</button>

	<table border=1>
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>이름</th>
			<th>관리</th>
		</tr>

		<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
		%>
				<tr>
					<td><%=list.get(i).getDeptno()%></td>
					<td><%=list.get(i).getDname()%></td>
					<td><%=list.get(i).getLoc()%></td>
					<!-- dept_editForm.jsp 로 전달하는 경로 만들기 -->
					<!-- <td><a href="#">수정</a><a href="#"> 삭제</a></td> -->
					<td><a href="dept_editForm.jsp?deptno=<%=list.get(i).getDeptno()%>">수정</a>
						<a href="javascript:delDept(<%=list.get(i).getDeptno()%>)"> 삭제</a>
					</td>
				</tr>
		<%
				}
			}
		%>
	</table>


	<!-- 삭제하는 함수 만들기 -->
	<script>
		function delDept(deptno) {
			if (confirm('정말 삭제하시겠습니까?')){
				location.href = 'dept_delete.jsp?deptno='+deptno;	
			}
		}
	</script>
	<%-- 테이블 만들면서 필요 없게 됨.
	out.println(list);
	--%>
</body>
</html>