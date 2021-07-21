<%-- <%@page import="java.sql.ResultSet"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//사용자가 전달하는 부서번호 받기
	String deptno = request.getParameter("deptno");
	//out.println(deptno);  -- 잘 받아왔는지 확인하는 용도
	

//전달받은 부서 번호로 부서 정보를 가져온다
	
	
	//데이터 베이스 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//연결
	Connection conn = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone-UTC";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
	//dept 받을 것이 필요
	Dept dept = null;

	String sqlSelect = "select * from dept where deptno=? ";
	pstmt = conn.prepareStatement(sqlSelect);
	pstmt.setInt(1, Integer.parseInt(deptno));
	
	rs = pstmt.executeQuery();
	
	if(rs.next()){
		dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
	}

	//	out.println(dept); 웸페이지에 어떻게 나오나 확인 용도
 
	// 부서 정보를 form_view.jsp로 전달을 한다. (혹은 공유)
	request.setAttribute("dept", dept);
	
%>
<jsp:forward page="form_view.jsp"/> --%>


<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자가 전달하는 부서번호 받기
	String deptno = request.getParameter("deptno");
	//out.println(deptno);
	
	// 전달받은 부서번호로 부서정보를 가져온다
	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	// 2. DB 연결
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone-UTC";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
	Dept dept = null;
	
	String sqlSelect = "select * from dept where deptno=? ";
	pstmt = conn.prepareStatement(sqlSelect);
	pstmt.setInt(1, Integer.parseInt(deptno));
	
	rs = pstmt.executeQuery();
	
	if(rs.next()){
		dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
	}
	
	//out.println(dept);
	
	// 부서정보를 form_view.jsp 전달(공유)
	request.setAttribute("dept", dept);
	
%>
<jsp:forward page="form_view.jsp"/>

