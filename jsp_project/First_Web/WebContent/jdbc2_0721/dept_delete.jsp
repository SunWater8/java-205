<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="dept.dao.DeptDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 1. 사용자가 전달하는 deptno 받고 - request 객체 사용

String deptno = request.getParameter("deptno");

//DB에 있는 데이터를 삭제
int resultCnt = 0;
//데이터 베이스 드라이버 로드
//연결
Connection conn = null;
DeptDao dao = DeptDao.getInstance();

try {
	conn = ConnectionProvider.getConnection();
	resultCnt = dao.deleteDept(conn, Integer.parseInt(deptno));
} catch (SQLException e) {
	e.printStackTrace();
} catch (Exception n) { //nullpointException
	n.printStackTrace();
} finally {
	JdbcUtil.close(conn);
}

if (resultCnt > 0) { //등록이 될 때
%>
<script>
	alert('삭제 되었습니다.');
	location.href = 'dept_list.jsp';
</script>
<%
} else { //등록이 안 될 때
%>
<script>
	alert("해당 데이터를 찾지 못했습니다.");
	location.href = 'dept_list.jsp';
</script>
<%
}
%>
