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

//아이디 저장을 위한 쿠키 설정하기
//reid 값의 유무 체크 후 저장
if(reid != null && reid.equals("on")){
	//쿠키 저장 : 사용자 ID 를 저장
	response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 60*60*24*365 ));
}


%>

<script>
	alert('로그인 되었습니다.');
	location.href = '<%=request.getContextPath()%>';  //  /mm 이렇게 생긴 경로가 표시될 것임.    
</script>