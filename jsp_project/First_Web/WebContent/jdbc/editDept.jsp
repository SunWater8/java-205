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
	
	//데이터 베이스 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//연결
	Connection conn = null;
	PreparedStatement pstmt= null;
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone-UTC";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
		
	
	//PreparedStatement 만들기
	String sqlUdate = "update dept set dname=?, loc=? where deptno=?";
	pstmt = conn.prepareStatement(sqlUdate);
	pstmt.setString(1, dname);
	pstmt.setString(2, loc);
	pstmt.setInt(3, Integer.parseInt(deptno));
	
	//반영된 횟수
	resultCnt = pstmt.executeUpdate();
	
	if(resultCnt>0){ //등록이 될 때
		%>
		<script>
			alert('수정 되었습니다.');
			
			//이동시키기 - href 속성에 위치 넣어주기
			location.href = 'dept_list.jsp';
		</script>
		<%
	}else{ //등록이 안 될 때 
		%>
		<script>
			alert("해당 데이터를 찾지 못했습니다. ");
			location.href = 'dept_list.jsp';
		</script>
		<%
	}
%>
