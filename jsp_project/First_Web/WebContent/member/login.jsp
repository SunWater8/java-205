<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	session.setAttribute("userName", request.getParameter("id"));
	//로그인을 하면 mypage로 이동하도록 처리하기
	response.sendRedirect(request.getContextPath()+"/member/mypage/mypage.jsp");
%>
