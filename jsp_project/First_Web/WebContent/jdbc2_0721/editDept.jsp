<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 1. 사용자가 입력한 데이터 받기 - request 객체 사용

//입력 데이터의 한글 처리!
request.setCharacterEncoding("utf-8");

String deptno = request.getParameter("deptno");
String dname = request.getParameter("dname");
String loc = request.getParameter("loc");

int resultCnt = 0;
//2. 데이터 입력db에 insert 

//연결
Connection conn = null;
DeptDao dao = null;
try {
	conn = ConnectionProvider.getConnection();
	dao = DeptDao.getInstance();

	resultCnt = dao.updateDept(conn, new Dept(Integer.parseInt(deptno), dname, loc));
} catch (SQLException e) {
	e.printStackTrace();
}
if (resultCnt > 0) { //등록이 될 때
%>
<script>
	alert('수정 되었습니다.');

	//이동시키기 - href 속성에 위치 넣어주기
	location.href = 'dept_list.jsp';
</script>
<%
} else { //등록이 안 될 때
%>
<script>
	alert("해당 데이터를 찾지 못했습니다. ");
	location.href = 'dept_list.jsp';
</script>
<%
}
%>
