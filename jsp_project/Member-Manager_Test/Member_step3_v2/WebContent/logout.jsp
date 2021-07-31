<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	//현재 세셕 객체 소멸 (세션에 올라간 메모리 사라짐)
	session.invalidate();
%>
<!-- 로그아웃 버튼 누르면 나오는 화면 -->
<script>
	alert('로그아웃 되었습니다.');
	location.href='<%= request.getContextPath()%>';
</script>