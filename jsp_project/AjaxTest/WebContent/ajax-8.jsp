<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
</style>
<script>

	//serialize() : 객체의 내용을 요청 매개변수 문자열로 변환해준다.
	//serializeArray() : 입력 양식의 내용을 객체로(배열로) 변환해 준다.
	$(document).ready(function(){
		
		$('#myform').submit(function(){ //submit 버튼 눌렀을 때 ajax 동작하기.
			
			//console.log($(this).serialize());
			//console.log($(this).serializeArray()); //객체로 반환
			
			$.ajax({
				url : 'parameter.jsp',
				//data : $(this).serialize(), 
				data : $(this).serializeArray(), 
				success : function(data){
					$('#menu').append(data);
				}
			})
			
			
			return false;
		});
		
		
	});
</script>
</head>
<body>

	<h1>제품 등록</h1>
	<hr>
	<form id="myform">

		제품 이름 : <input type="text" id="pname" name="pname"><br> 
		제품 가격 : <input type="number" id="price" name="price"><br> 
		<input type="submit" id="btn">
	</form>
	<hr>

	<div id="menu">
		<h3>메뉴표</h3>
		<hr>
	</div>

</body>
</html>