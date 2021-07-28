<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>

	<h1>파일 업로드</h1>
	<!-- 필수적으로 입력해야 하는 두 가지 -method, enctype -->
	<!-- 
	필수1: form tag 속성 method-"post"
	필수2: form tag 속성 enctype="multipart/form"
	 -->
	<form action="upload.jsp" method = "post" enctype="multipart/form-data">
		제목 <input type="text" name="title"><br>
		제목2 <input type="text2" name="title2"><br>
		파일 <input type="file" name="photo"><br>
		파일 <input type="file" name="file"><br>
		<input type="submit">
	
	</form>

</body>
</html>