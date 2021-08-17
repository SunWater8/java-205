<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String idx = request.getParameter("idx");
String userId = request.getParameter("userid");
String userPw = request.getParameter("pw");
String userName = request.getParameter("name");
String joinDate = request.getParameter("joindate");

int resultCnt = 0;

Class.forName("com.mysql.cj.jdbc.Driver");

Connection conn = null;
PreparedStatement pstmt = null;
try{
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone-UTC";
	String user = "bit";
	String pw = "bit";

	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
	String sqlInsert = "insert into members values(default, ?,?,?,default)";
	pstmt = conn.prepareStatement(sqlInsert);
	pstmt.setString(1, userId);
	pstmt.setString(2, userPw);
	pstmt.setString(3, userName);
	
	resultCnt = pstmt.executeUpdate();
	
}catch(SQLException e){
	e.printStackTrace();
}

if(resultCnt >0){
%>
<script>
	alert('가입 되었습니다.');
	location.href='member_list.jsp';
</script>
<%
}else{
%>
<script>
	alert('오류가 발생하여 등록되지 않았습니다. \n 입력 페이지로 이동합니다.')
	window.history.go(-1);
</script>
<%
}%>