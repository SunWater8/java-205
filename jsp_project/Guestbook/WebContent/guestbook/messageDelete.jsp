<!-- 
이 파일의 역할 : 정보 지워 달라고 서비스에 요청하기 - DB 갔다올 예정
해당 게시물이 있는지 확인. 아이디와 패스워드가 일치하는 지 여부 -> 모두 통과되면 삭제 됨.
 -->
<%@page import="guest.exception.InvalidPasswordException"%>
<%@page import="guest.exception.MessageNotFoundException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="guest.service.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//데이터 받고 -> service에 요청 -> Dao 처리
	String mid = request.getParameter("mid");
	String pw = request.getParameter("password");
	
	String msg = "정상적으로 삭제되었습니다.";
	
	try{
	DeleteMessageService.getInstance().deleteMessage(Integer.parseInt(mid), pw);
	}catch(SQLException e){
		msg = "삭제하는 도중 문제가 발생했습니다. 다시 시도해 주세요.";
	}catch(MessageNotFoundException e){
		msg = e.getMessage();
	}catch(InvalidPasswordException e){
		msg = e.getMessage();
	}
	
	request.setAttribute("msg",msg);
%>

<jsp:forward page="delete_view.jsp"/>