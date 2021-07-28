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
		$('#btn').click(function(){
			$.ajax({
				url: 'parameter.jsp',
				type:'post', //http의 메소드 - get, post, put, delete 이 네가지 형태로 보낼 수 있따.
				data: {
					//pname : '우유',
					pname : $('#pname').val(),
					//price : 1000
					price : $('#price').val()
				},//문자열 형식  ?name=test&price=1000, 객체 형식으로 {}
				success : function(data){
					//alert(data);
					//$('body').html(data);
					$('#menu').append(data);
				}
			});
		});
		
		
	});
</script>
</head>
<body>
	<!-- ajax-3.jsp -->
	
	<h1>제품 등록</h1>
	<hr>
	제품 이름 : <input type="text" id="pname"><br>
	제품 가격 : <input type="number" id="price"><br>
	<input type="submit" id="btn">
	<hr>
	
	<div id="menu">
		<h3>메뉴표</h3>
		<hr>
	</div>
	
</body>
</html>