<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    /* 배열 타입으로 쿠키 받기 - 클라이언트가 보낸 쿠키 읽기*/
    Cookie[] cookies = request.getCookies();
    %>
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
	<%
		if(cookies !=null && cookies.length>0){
			for(int i =0; i<cookies.length; i++){
				// getName() : 쿠키의 이름 반환
				String name = cookies[i].getName();
				// getVlaue() : 현재 쿠키의 값을 가져오기
				String value = cookies[i].getValue();

				//화면에 출력 되길 원하는 쿠키 이름 정하기
				if(name.equals("cname")){
				out.println("<h1>"+name+" = "+value+"</h1>");
				}
			}
		}
	%>
	
	<a href="editCookie.jsp">쿠키 수정</a>
	<a href="deleteCookie.jsp">쿠키 삭제</a>
</body>
</html>