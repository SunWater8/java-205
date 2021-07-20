<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 사용자가 전달하는 deptno 받고 - request 객체 사용
	
	String deptno = request.getParameter("deptno");
	
	//DB에 있는 데이터를 삭제
	int resultCnt = 0;
	
	//실행 결과에 맞는 응답??
	
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
	String sqlDelete = "delete from dept where deptno=?";
	pstmt = conn.prepareStatement(sqlDelete);
	pstmt.setInt(1, Integer.parseInt(deptno));
	
	//반영된 횟수
	resultCnt = pstmt.executeUpdate();
	
	if(resultCnt>0){ //등록이 될 때
		%>
		<script>
			alert('삭제 되었습니다.');
			location.href = 'dept_list.jsp';
		</script>
		<%
	}else{ //등록이 안 될 때 
		%>
		<script>
			alert("해당 데이터를 찾지 못했습니다.");
			location.href = 'dept_list.jsp';
		</script>
		<%
	}
%>
