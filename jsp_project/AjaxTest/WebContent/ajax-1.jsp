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
		
		//data.html이라는 경로를 가지고 바디에다가 data.html의 모든 소스를 붙여넣기하기.
		$.ajax('data.html',{//data.html라고 쓰여진 자리는 경로가 들어가야 함.{}안에는 속성이 들어감.
			success: function(data){ //success 속성은 data.html를 호출했을 때 성공하면 다음에 이어지는 success 핸들러 function을 수행하게 된다.
				$('body').append(data); // 기존의 body안에 data를 넣도록 하기.
			}
		}); 
	});
</script>
</head>
<body>
	ajax-1.jsp
</body>
</html>