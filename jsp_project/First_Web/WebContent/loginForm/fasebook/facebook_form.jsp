<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>facebook login</title>
  <link rel="stylesheet" href="facebook.css">
<style>
</style>
<script>
</script>
</head>
<body>
    <!-- 본문 영역 -->
    <div class="background_grey">
        <div id="main_wrap">
            <!-- 제목, 소개 영역-->
            <header>
                <img src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg">
                <h1>Facebook에서 전세계에 있는 친구, 가족, 지인들과 함께 이야기를 나눠보세요.</h1>
            </header>
            <!-- 로그인 박스 영역-->
            <section>
                <div id="loginbox">
                    <!-- form 시작-->
                    <form action="facebook_result.jsp" method="get">
                        <input type="text" placeholder="이메일 또는 전화번호" class="blankbox" name="userid">
                        <input type="password" placeholder="비밀번호" class="blankbox" name="userpw">
                        <input type="submit" value="로그인" class="width_350 background_blue font_white">
                    </form>
                    <!-- form 끝 -->
                    <p><a href="#" class="font_blue">비밀번호를 잊으셨나요?</a></p>
                    <div class="border"> </div>
                    <div class="account">
                        <a class="account_text" href="#" target="_blank" title="Banner">새 계정 만들기</a>
                    </div>

                </div>
                <p>유명인, 밴드, 비즈니스를 위한 <b><a href="#" class="font_black">페이지 만들기</a></b></p>
            </section>
        </div>
    </div>

    <!-- footer 영역 -->
    <footer>
        <div id="foot_wrap">
            <ul>
                <li><a href="#">한국어</a></li>
                <li><a href="#">English(US)</a></li>
                <li><a href="#">Tiếng Việt</a></li>
                <li><a href="#">Bahasa Indonesia</a></li>
                <li><a href="#">ภาษาไทย</a></li>
                <li><a href="#">Español</a></li>
                <li><a href="#">简体</a></li>
                <li><a href="#">中文</a></li>
                <li><a href="#">日本語</a></li>
                <li><a href="#">Português (Brasil)</a></li>
                <li><a href="#">Français (France)</a></li>
                <li><a href="#">Deutsch</a></li>

                <li><input class="float_left box_size" type="button" value="+"></li>
            </ul>
        </div>

        <div class="border2"> </div>

        <ul>
            <li><a href="#">가입하기</a></li>
            <li><a href="#">로그인</a></li>
            <li><a href="#">Messenger</a></li>
            <li><a href="#">Facebook Lite</a></li>
            <li><a href="#">Watch</a></li>
            <li><a href="#">사람</a></li>
            <li><a href="#">페이지</a></li>
            <li><a href="#"> 페이지 카테고리</a></li>
            <li><a href="#"></a></li>
            <li><a href="#"></a></li>
            <li><a href="#">Facebook Pay</a></li>
            <li><a href="#"></a></li>
            <li><a href="#">그룹채용 정보</a></li>
            <li><a href="#">장소</a></li>
            <li><a href="#">게임</a></li>
            <li><a href="#">위치</a></li>
            <li><a href="#">Market</a></li>
            <li><a href="#">place</a></li>
            <li><a href="#">Oculus</a></li>
            <li><a href="#">Portal</a></li>
            <li><a href="#">Instagram</a></li>
            <li><a href="#">지역</a></li>
            <li><a href="#">기부</a></li>
            <li><a href="#">캠페인</a></li>
            <li><a href="#">서비스</a></li>
            <li><a href="#"> 투표 정보 센터</a></li>
            <li><a href="#">정보</a></li>
            <li><a href="#">광고 만들기</a></li>
            <li><a href="#">페이지 만들기</a></li>
            <li><a href="#">개발자</a></li>
            <li><a href="#"> 채용 정보</a></li>
            <li><a href="#">개인정보처리방침</a></li>
            <li><a href="#">쿠키</a></li>
            <li><a href="#">AdChoices</a></li>
            <li><a href="#">이용 약관</a></li>
            <li><a href="#">고객 센터</a></li>
        </ul>

        <p class="font_black"><a href="https://www.facebook.com/" class="font_black" target="_blank">Facebook</a> © 2021
        </p>
    </footer>
</body>
</html>