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
		
		// get() : get 방식으로 수행
		$.get('data.html', (function(data)){
			//success 되었을 때 처리할 내용
			$('body').html(data);
		});
		 
		 
		 //post() : post 방식으로 수행
		$.post('data.html', (function(data)){
			$('body').html(data);
		});

	});
</script>
</head>
<body>
	
</body>
</html>