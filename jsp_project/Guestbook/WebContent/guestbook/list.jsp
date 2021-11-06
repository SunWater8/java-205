<%@page import="guest.domain.MessageListView"%>
<%@page import="guest.service.MessageListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//사용자로부터 페이지 번호를 받는다. 사용자 요청에서 페이지를 클릭했을 경우 list.jsp?page=3, 페이지를 클릭하지 않았을 경우의 사용자 요청 list.jsp
String pageNumStr = request.getParameter("page");
// 요청이 들어오지 않으면 첫 페이지 보여주기. - 페이지를 클릭하지 않았을 경우 기본값으로 페이지를 1쪽으로 한다.
int pageNum = 1;
// 페이지를 클릭했다면 숫자로 변환해주기.
if (pageNumStr != null) {
	pageNum = Integer.parseInt(pageNumStr);
}

//service 클래스로 pageNum을 전달하기  
MessageListView listView = MessageListService.getInstance().getMessageList(pageNum);
request.setAttribute("listView", listView);

%>
<jsp:forward page="list_view.jsp"/>