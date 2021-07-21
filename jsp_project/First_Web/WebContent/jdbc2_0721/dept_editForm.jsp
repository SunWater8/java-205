<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//사용자가 전달하는 부서번호 받기
String deptno = request.getParameter("deptno");
//연결
Connection conn = null;
DeptDao dao = null;
try {
	conn = ConnectionProvider.getConnection();
	//dao 가져오기
	dao = DeptDao.getInstance();

	// 부서 정보를 form_view.jsp로 전달을 한다. (혹은 공유)
	request.setAttribute("dept", dao.selectByDeptno(conn, Integer.parseInt(deptno)));

} catch (SQLException e) {
	e.printStackTrace();
}
%>
<jsp:forward page="form_view.jsp" />




