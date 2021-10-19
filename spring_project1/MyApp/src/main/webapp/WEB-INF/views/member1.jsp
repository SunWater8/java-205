<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<script>
	$(document).ready(function(){
		
		//완성되지 않은 ajax이기 때문에 이 처리에 대한 결과는 웹페이지 창에서 f12의 console에서 회원전체를 배열 형태로 확인할 수 있다. 
		$.ajax({
			url : 'http://localhost:8080/op/members', //open project에서 회원전체 리스트를 보여주는 경로
			type : 'GET',
			success : function(data){
				console.log(data);
			}
		});
	});
</script>
</head>
<body>

	<h1>회원 리스트</h1>
	<hr>
	<div id="memberlist">
	
		<!-- ajax로 이 div 공간에 회원 전체 리스트를 넣을 예정.  -->

	
	</div>


</body>
</html>