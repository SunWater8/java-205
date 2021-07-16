<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>naver signup</title>
 <link rel="stylesheet" href="naver_signup.css">
</head>
<body>
    <div id="wrap">
        <!-- header -->
        <header>
            <h1>NAVER</h1>
        </header>
        <!-- sing-in form -->
        <form action="naverSignup_result.jsp" method="post">
            <div>
                <!-- id -->
                <label for="id">아이디</label>
                <div class="onebox" id="id_box">
                    <input type="text" id="id" name="userid">
                    <p class="hold">@naver.com</p>
                </div>

            </div>
            <div>
                <!-- pw -->
                <label for="pw">비밀번호</label>
                <input class="onebox" type="password" id="pw" name="userpw">
            </div>
            <div>
                <label for="pw2">비밀번호 재확인</label>
                <input class="onebox" type="password" id="pw2">
            </div>
            <div>
                <!-- 이름 -->
                <label for="name">이름</label>
                <input class="onebox" type="text" id="name" name="username">
            </div>
            <div>
                <!-- 생년월일 -->
                <label for="year">생년월일</label>
                <div id="birth">
                    <input type="text" id="year" placeholder="년(4자)" name="birthyear">
                    <select name="birthmonth">
                        <option>월</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                        <option>11</option>
                        <option>12</option>
                    </select>
                    <input type="text" placeholder="일" name="birthdate">
                </div>
            </div>
            <div>
                <label for="gender">성별</label>
                <select class="onebox_select" id="gender" name="gender">
                    <option>성별</option>
                    <option>남자</option>
                    <option>여자</option>
                    <option>선택안함</option>
                </select>
            </div>
            <div>
                <!-- 이메일 -->
                <label for="email">본인 확인 이메일<span class="dif_font">(선택)</span></label>
                <input class="onebox" type="email" id="email" placeholder="선택입력" name="email">
            </div>
            <div>
                <!-- 전화 -->
                <label for="phone">휴대전화</label>
                <select class="onebox_select" id="phone" name="phoneNation">
                    <option>대한민국 +82</option>
                    <option>영국 +44</option>
                </select>
            </div>
            <div id="phone">
                <input type="tel" placeholder="전화번호 입력" name="phonenum">
                <input type="button" value="인증번호 받기" >
                <input type="text" placeholder="인증번호 입력하세요." name="inputnum">
            </div>
            <!-- 가입하기 버튼 -->
            <input type="submit" value="가입하기">
        </form>
        <!-- footer -->
        <footer>
            <ul>
                <li>이용약관 |</li>
                <li><b>개인정보처리방침</b> |</li>
                <li>책임의 한계와 법적고지 |</li>
                <li>회원정보 고객센터</li>
            </ul>
            <p>© NAVER Corp</p>
        </footer>
    </div>
</body>
</html>