<%@page import="member.domain.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Class.forName("com.mysql.cj.jdbc.Driver"); 

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
String user = "bit";
String pw = "bit";

conn=DriverManager.getConnection(jdbcUrl, user, pw);

stmt = conn.createStatement();
String sqlSelect = "select * from members";
rs=stmt.executeQuery(sqlSelect);

List<Member> memberList = new ArrayList<Member>();

while(rs.next()){
	memberList.add(new Member(rs.getInt("idx"), rs.getString("userid"), rs.getString("pw"), rs.getString("name"), rs.getString("joindate")));
}

out.println(memberList);
request.setAttribute("result", memberList);

%>
<jsp:forward page="list_view.jsp"/>