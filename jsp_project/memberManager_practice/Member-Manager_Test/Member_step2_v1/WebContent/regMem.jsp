<%@page import="dao.MemberDao"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

/* String idx = request.getParameter("idx");
String userId = request.getParameter("userid");
String userPw = request.getParameter("pw");
String userName = request.getParameter("name");
String joinDate = request.getParameter("joindate"); */

// Member 객체의 모든 변수를 가져올 때엔 usebean 사용
// domail.Member 클래스를 member라는 id로 지정을 하고 , member에서 모든 속성을 들고 온다.
%>
<jsp:useBean id="member" class="domain.Member"/>
<jsp:setProperty property="*" name="member"/>


<%
int resultCnt = 0;
MemberDao dao = null;
Connection conn = null;

try{
	conn = ConnectionProvider.getConnection();
	dao = MemberDao.getInstance();
	resultCnt = dao.insertMem(conn, member);
	
}catch(SQLException e){
	e.printStackTrace();
}

if(resultCnt >0){
%>
<script>
	alert('가입 되었습니다.');
	//location.href='member_list.jsp';
	location.href = '<%= request.getContextPath()%>/index.jsp';
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