<!-- 0719(1) sendRedirect와 forward의 차이 -->
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

	<%
		String select = request.getParameter("select"); //getParameter는 String을 반환.
		int selNum = Integer.parseInt(select); //select가 null이 아니다는 것을 가정하고 int 형으로 변환
		if(selNum>0){  //value 가 1일 때
			out.println(selNum);
			//sendRedirect(경로) -> 현재 페이지가 응답 처리 되고난 후 경로의 페이지를 요청
			response.sendRedirect("result.jsp");
		}else{
			out.println(selNum);
			//forward 처리
			%>
				<!-- 현재 페이지 resultPage.jsp가 응답이 되는 것이 아니라 result.jsp 파일의 결과를 바로 응답처리한다 -->.
				<jsp:forward page="result.jsp"/>
				
			<%
		}
	%>

</body>
</html>