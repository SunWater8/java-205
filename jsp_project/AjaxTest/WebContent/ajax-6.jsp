<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
</style>
<script>
//html 에서 입력한 것과 같다.
	$(document).ready(function(){
		//load() : Ajax를 수행하고 선택자로 선택한 문서 객체 안에 데이터 삽입하기.
		$('body').load('data.html'); //특정 태그 안에 html을 넣어주기.
	});
</script>
</head>
<body>
	test
</body>
</html>