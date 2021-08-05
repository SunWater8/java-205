<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>파일 업로드 : report 제출</h1>
 <hr>
 <h3>@RequestParam 을 이용한 파일 업로드</h3>
 <form action="upload1" method="post" enctype="multipart/form-data">
 	학번 : ${sno }<br>
 	이름 : ${sname }<br>
 	파일 : ${reportfile }<br>
 
 </form>
</body>
</html>