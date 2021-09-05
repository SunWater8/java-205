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
	//xml형식에서 파싱하여 html 에서 입력한 것과 같이 만들도록 한다.
	$(document).ready(function() {

		$.ajax({
			url : 'data.xml',
			success : function(data) {
				
				$(data).find('product').each(function(){  //data를 객체로 만들면 find 메소드 쓸 수 있다.
					var pname = $(this).find('name').text();
					var price = $(this).find('price').text();
					var html = '<h3>이름 : '+pname+', 가격 : '+price+'</h3>';
					//body에 넣기
					$('body').append(html);
				});
			}
		});
	});
</script>
</head>
<body>
</body>
</html>