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

	<h3>
	<%-- 
		1. 선택한 상품 : ${param.select }
		param은 사용자가 입력하는 값이라서 이렇게 쓰이는 경우는 많지 않다.
		2. 상품 설명 : ${product.display }
		display 변수는 없다. 실제로 EL은 메소드를 호출하는 것이다.
		3. 첫번째 상품 ${product.productList[0] }
		getProductList()를 호출하는 거와 같은데 그러면 배열이 반환되므로 [0]을 뒤에 써준다.
		
	--%>
		param.select : ${param.select }
		<br>
		product.display : ${product.display }
		<br>
		product.productList[0] : ${product.productList[0] }
	</h3>


</body>
</html>