<%@page import="util.ConnectionProvider"%>
<%@page import="domain.Member"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//변수 초기화
	String memberId = request.getParameter("memberid");
	String password = request.getParameter("password");
	String reId= request.getParameter("reid");

	Connection conn = null;
	MemberDao dao = null;
	
	
	conn = ConnectionProvider.getConnection();
	dao = MemberDao.getInstance();
	Member member = new Member();
	
	member = dao.selectByIdPw(conn, memberId, password);
%>
