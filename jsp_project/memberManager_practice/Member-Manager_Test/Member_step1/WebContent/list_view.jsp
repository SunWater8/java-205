<%@page import="domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<Member> list = (List<Member>) request.getAttribute("result");
%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td{
		text-align: center;
		padding:5px 10px;
	}
	
	button{
		margin: 5px 0;
	}
</style>
</head>
<body>
	<h1>회원 정보 리스트</h1>
	<hr>
	
	<button onclick="location.href ='mem_regForm.jsp';">회원 정보 등록</button>
	
	<table border=1>
		<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>가입 일자</th>
		</tr>
		
		<%
		if(list != null) {
			for(int i=0; i<list.size(); i++){
		%>
				<tr>
					<td><%= list.get(i).getUserid() %></td>
					<td><%= list.get(i).getPw() %></td>
					<td><%= list.get(i).getName() %></td>
					<td><%= list.get(i).getJoindate() %></td>
				</tr>	
		<%
			}
		}
		%>

	</table>
</body>

</html>