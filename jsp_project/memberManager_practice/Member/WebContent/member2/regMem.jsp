
<%@page import="member.domain.Member"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String userId = request.getParameter("userid");
String userPw = request.getParameter("pw");
String userName = request.getParameter("name");

int resultCnt = 0;

Connection conn = null;
MemberDao dao = MemberDao.getInstance();

try{
	
conn=ConnectionProvider.getConnection();
resultCnt = dao.insertMem(conn, new Member( userId, userPw, userName));

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
}

%>

