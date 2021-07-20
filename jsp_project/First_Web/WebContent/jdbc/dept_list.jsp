<%@page import="java.util.ArrayList"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
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

conn= DriverManager.getConnection(jdbcUrl, user, pw);
//jdbc 와 연결하는 과정 끝

stmt = conn.createStatement();
//sql 문 만들기
String sqlSelect = "select * from dept";

rs = stmt.executeQuery(sqlSelect); //executeQuery는 resultSet 을 반환

//--------------------------------------------------------
List<Dept> deptList = new ArrayList<Dept>();  //각 단어마다 import 하기

//반복하면서 deptList 에 객체를 넣어주기
while(rs.next()){//rs에 다음 요소가 있는지 확인
	//List 에 객체 추가
	deptList.add(
			new Dept(
					rs.getInt("deptno"), 
					rs.getString("dname"), 
					rs.getString("loc")
					)
			);

}
out.println(deptList);

//6. 결과 데이터 request의 속성에 저장 > 데이터 공윺(전달)
request.setAttribute("result", deptList);
%>
<jsp:forward page="list_view.jsp"/>
