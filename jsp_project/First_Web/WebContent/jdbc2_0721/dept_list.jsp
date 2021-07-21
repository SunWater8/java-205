
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

//dept_list....필기 놓침

//1. 드라이버 로드
//2. DB 연결
Connection conn = null;
DeptDao dao = DeptDao.getInstance();  // DeptDao.java 생성 이후 새로 추가된 문장. 싱글톤 생성 후 또 한번 수정.

conn=ConnectionProvider.getConnection();
//jdbc 와 연결하는 과정 끝

//6. 결과 데이터 request의 속성에 저장 > 데이터 공윺(전달)
//request.setAttribute("result", deptList); class로 따로 만들면서 이 문장 필요 없어짐.(DeptDao.java)
request.setAttribute("result", dao.getDeptList(conn)); // DeptDao.java 파일 만든 후 이 문장 수정
%>
<jsp:forward page="list_view.jsp"/>
