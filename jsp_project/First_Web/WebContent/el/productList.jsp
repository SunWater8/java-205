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
	<jsp:useBean id="product" class="product.Product" scope="session"/>
<!-- 	
	여기서 usebean 의 역할
	1. session 객체의 product 이름으로 된 속성이 있는지 확인.
	2. 속성이 있다면 -> 현재 product 이름의 변수에 session 영역에 저장되어 있는 객체를 저장한다.
	3. 속성이 없다면 -> product.Product 클래스로 객체 생성 하고, 
					session 영역의 속성에 product라는 이름으로 객체를 저장한다. 
	자바로 표현한다면				
	Product p = session.getAttribute(product);					
	if(p==null){
		p = new Product();
		session.setAttribute("product",p);
	}
	 -->
	 
	 <!-- id="product"에서 product를 참조변수처럼 사용. -->
	 <%=product %><br>
	 ${product }
	 <!-- 스프링에서는 좀 더 쉽게 사용할 수 있기에 이런 식으로 사용은 별로 많지 않다. -->
	 
	 
	 
	 <hr>
	 <h1>상품 리스트 : 원하시는 상품을 선택하세요</h1>
	 <form action = "productSelect.jsp">
	 	<select name="select">
	 		<%
	 		
	 		for(int i=0; i<product.getProductList().length;i++){
	 			out.println("<option>"+product.getProductList()[i]+"</option>");
	 		}
	 		%>
	 	
	 	</select>
	 	<input type="submit">
	 </form>
	 
	 
	 
	 
	 
	 
	 
</body>
</html>