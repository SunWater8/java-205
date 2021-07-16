<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Naver Login</title>
<link rel="stylesheet" href="naver_login.css">
</head>
<body>
    <!-- 전체 영역 -->
    <div id="wrap">
        <!-- header -->
        <header>
            <h1>NAVER</h1>
        </header>
        <!-- login form -->
        <form action="naverLogin_result.jsp" method="post" >
            <input type="text" name="userid">
            <input type="password" name="userpw">
            <input type="submit" value="로그인">
        </form>
    </div>
</body>
</html>