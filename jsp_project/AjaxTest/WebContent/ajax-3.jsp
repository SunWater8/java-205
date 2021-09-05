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
		$('#btn').click(function(){//#btn을 클릭하면은 ajax 통신 하여
			$.ajax({
				url: 'parameter.jsp',
				type:'post', //http의 메소드 - get, post, put, delete 이 네가지 형태로 보낼 수 있따.
				data: {  //data는 보내야 할 파라미터를 의미. 문자열 형식으로 되어 있거나, 객체 형식으로 되어 있다.
					     //문자열 형식  ?name=test&price=1000, 객체 형식으로 {}
					//pname : '우유',
					pname : $('#pname').val(),//input type='text'에서 입력받은 문자열 가져오기
					//price : 1000
					price : $('#price').val()
				},
				success : function(data){
					//alert(data); //data가 무엇을 담고 있는지 확인하기. parameter.jsp 파일 내용대로 응답 결과가 나옴 - <h1>우유 : 1000</h1>
					//$('body').html(data);
					$('#menu').append(data); //빈칸에 입력을 하면 입력한 대로 #menu 아래 hr 밑에 추가가 됨.
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