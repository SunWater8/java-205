<%@page import="java.util.ArrayList"%>
<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<Member> members = new ArrayList<Member>();

	members.add(new Member("cool00", "1110", "COOL00"));
	members.add(new Member("cool001", "1111", null));
	members.add(new Member("cool002", "1112", "COOL00"));
	members.add(new Member("cool003", "1113", "COOL00"));
	members.add(new Member("cool004", "1114", null));
	members.add(new Member("cool005", "1115", null));
	members.add(new Member("cool006", "1116", "COOL00"));
	members.add(new Member("cool007", "1117", null));
	members.add(new Member("cool008", "1118", "COOL00"));
	members.add(new Member("cool009", "1119", "COOL00"));
	
	//run as 하면 서버가 끊기기 전까지 이 데이터를 이용할 수 있게 된다.
	session.setAttribute("members", members);
%> 