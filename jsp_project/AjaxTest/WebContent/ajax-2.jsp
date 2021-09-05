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
	$(document).ready(function(){
		
	//전체 속성을 객체로 표현하기 - ajax-1.jsp와 같은 내용. 
		$.ajax({
			url: 'data.html',
			success : function(data){
				$('body').html(data);
			}
		});
	});
</script>
</head>
<body>
	ajax-2.jsp
</body>
</html>