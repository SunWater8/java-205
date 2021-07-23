<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
  
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

<!-- 천 단위로 콤마 넣기. -->
<c:set var="number" value="1000000"/>
<fmt:formatNumber value="1000000"/>

<br>
<!-- 콤마 사라지게 하기 -->
<fmt:formatNumber value="1000000" groupingUsed="false"/>

<br>

<fmt:formatNumber value="${number }"/>

<br>
<!-- 기본 형태로 출력 -->
<fmt:formatNumber value="${number }" type="number"/>

<br>
<!-- 결과 값을 소수점 이하 절사하고 퍼센트로 표현 -->
<fmt:formatNumber value="${number/4000000 }" type="percent"/>

<br>
<!--원화 단위 표현  -->
<fmt:formatNumber value="${number }" type="currency" />

<br>
<!--내가 임의로 문자 추가하기-->
<fmt:formatNumber value="${number }" type="currency" currencySymbol="$"/>

<br>
<!-- 자릿수마다 표현하기 -->
<fmt:formatNumber value="${number }" pattern="0,000,000.00"/>

<br>
<!-- 연산을 해도 자릿수 표현 -->
<fmt:formatNumber value="${number *1000 }" pattern="0,000,000.00"/>


</body>
</html>