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
		//getJSON() : get방식으로 ajax를 수행하여 JSON데이터로 반환하는 메소드.
		$.getJSON('data.json', function(data){ //data는 javaScript객체로 반환이 되므로 each메소드를 이용한 반복문에서 data가 배열 하나하나의 요소로 작동하게 된다.
			$.each(data, function(index, value){
				var html = '<h3>이름: '+value.name+', 가격 : '+value.price+'</h3>';
				$('body').append(html); //파싱하기 : json으로 된 다른형태의 데이터를 html이라는 다른형태의 데이터로 바꾸어서 처리하는 것을 의미
			});
		});

	});
</script>
</head>
<body>
	
</body>
</html>