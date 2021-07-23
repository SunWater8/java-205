<%@page import="java.sql.SQLException"%>
<%@page import="domain.Member"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//사용자가 전달한 데이터를 받고 -> DB에서 확인 -> 로그인 처리
//있으면 로그인 처리 , 없으면 '아읻 또는 비밀번호가 등록되지 않았습니다'라고 출력

//reid 확인 하고 값을 받아오면 쿠키 설정해주기 - 기억하고자 하는 아이디를 가져오기

//값을 받아 오기
String memberId = request.getParameter("memberid");
String password= request.getParameter("password");
String reid= request.getParameter("reid");

boolean loginChk = false;

Connection conn = null;
MemberDao dao = null;

//id가 3자 이상, pw가 4자 이상 입력되었을 때 조건 문
if(memberId!=null && password!=null && memberId.trim().length()>2 && password.trim().length()>3){
	
	try{
		
	conn = ConnectionProvider.getConnection();
	dao = MemberDao.getInstance();
	
	Member member = dao.selectByIdPw(conn, memberId, password);
	if(member != null){
		session.setAttribute("loginInfo", member.toLoginInfo());
		loginChk = true;
	}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
}



//아이디 저장을 위한 쿠키 설정하기
//reid 값의 유무 체크 후 저장
if(reid != null && reid.equals("on")){
	//쿠키 저장 : 사용자 ID 를 저장
	response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 60*60*24*365 ));
}
else{
	//쿠키를 저장하지 않는다.
	response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 0));
}



%>

<script>
	alert('로그인 되었습니다.');
	location.href = '<%=request.getContextPath()%>
	'; //  /mm 이렇게 생긴 경로가 표시될 것임.
</script>