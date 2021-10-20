<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>form.jsp</h1>
	<form method="post">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit">
	</form>
	
	<!-- 폼 안의 파라미터를 가지고 name=?&age=? 이렇게 사용자로부터 요청을 받아  바디 안에 넣어서 전송하게 되면 @RequestBody 가 이 전체를 통째로 받는다.  
		 @ResponseBody 는 String으로 그대로 응답 반환 한다. -->
</body>
</html>