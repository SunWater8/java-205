<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//session 에 member 라는 객체가 있는지 확인.
//로그인 상태라면 loginObj에 member 객체가 들어가 있을 것이고, 
//로그인 상태가 아니라면 null 값이 들어갈 것이다.

//toLoginInfo 메소드 생성 후 수정되었기에 주석처리
//Object loginObj = session.getAttribute("member");

//toLoginInfo 메소드 생성 후 수정
Object loginObj = session.getAttribute("loginInfo");
%>
	<nav>
		<ul>
		<!-- 로그인 되지 않았을 떄는 회원가입, 로그인 글자가 보이면 되고,
			 (else) 로그인 된 상태라면 로그아웃, 회원리스트 글자가 보여야 한다.-->
			<%if(loginObj == null){ %>
				<li><a href="<%= request.getContextPath()%>/regForm.jsp">회원가입</a></li>
				<li><a href="<%= request.getContextPath()%>/loginForm.jsp">로그인</a></li>
			<%}else{ %>
			
				<li><a href="<%= request.getContextPath()%>/logout.jsp ">로그아웃</a></li>
				<li><a href="<%= request.getContextPath()%>/member_list.jsp">회원리스트</a></li>
			<%} %>
			<li>
				<li><a href="<%= request.getContextPath()%>/mypage.jsp">My Page</a></li>
			</li>
		</ul>
	</nav>