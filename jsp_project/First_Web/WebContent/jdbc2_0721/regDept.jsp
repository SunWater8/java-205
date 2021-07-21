
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.dao.DeptDao"%>
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
	
	int resultCnt =0;
	//2. 데이터 입력db에 insert 
	
	//데이터 베이스 드라이버 로드
	
	Connection conn = null;
	DeptDao dao = DeptDao.getInstance();
	try{
	//연결
	
	conn=ConnectionProvider.getConnection();
		
	
	//PreparedStatement 만들기
	String sqlInsert = "insert into dept values(?, ?, ?)";
	pstmt = conn.prepareStatement(sqlInsert);
	pstmt.setInt(1, Integer.parseInt(deptno));
	pstmt.setString(2, dname);
	pstmt.setString(3, loc);
	
	//반영된 횟수
	resultCnt = dao.insertDept(conn);
	
	//out.println(resultCnt);
	
	//insert 처리 - 결과는 int
	
	}catch (Exception e){
		
	}
	//3. dept_list.jsp로 이동
	//response.sendRedirect("dept_list.jsp");
	
	if(resultCnt>0){ //등록이 될 때
		%>
		<script>
			alert('등록되었습니다.');
			
			//이동시키기 - href 속성에 위치 넣어주기
			location.href = 'dept_list.jsp';
		</script>
		<%
	}else{ //등록이 안 될 때 
		%>
		<script>
			alert("오류 발생으로 등록되지 않았습니다.\n 입력페이지로 다시 이동합니다.");
			//폼으로 이동하기
			//location.href = 'dept_regForm.jsp';
			
			//이전 페이지로 이동
			window.history.go(-1);
		</script>
		<%
	}
%>
