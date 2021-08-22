<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
//회원가입이 성공하면 redirect 될 것이기 때문에 이 페이지에서는 회원가입이 실패할 경우에 보여주는 view로 만들도록 한다.
	alert('회원가입 처리중 오류가 발생했습니다.\n다시확인해주세요.');
	history.go(-1); //form으로 돌아가기
</script>