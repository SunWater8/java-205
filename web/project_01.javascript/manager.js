/* 
회원의 정보 : 아이디, 비밀번호, 이름
Member -> 생성자 함수를 정의
 */

function Member(id, pw, name) {
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}
// 객체가 가지는 메소드는 공통으로 사용 -> prototype
Member.prototype.makeHtml = function () {
    return '[id:'+this.userId +' , pw: '+ this.pw +' , name: '+this.userName+' ]';
};
// var member = new Member();


// /------------------------------------------------------------------------
// 사용자가 입력한 정보를 가지고 Member 객체를 생성
//submit 이벤트 연결 - 캐스팅되어야 가능.

window.onload = function () {

    // regForm 캐스팅
    var regForm = document.getElementById('regForm');
    regForm.onsubmit = function () {
        // alert('submit');  // 적용 되었는지 확인 용.


        /* 앞으로 만들어갈 것들.
        사용자가 입력한 폼 정보 받기.
        유효성 검사
        비밀번호 두 번 입력한 것 끼리 비교하기 */

        //사용자가 입력한 값.
        var userid = document.querySelector('#userID').Value;
        var pw = document.querySelector('#pw').value;
        var repw = document.querySelector('#repw').value;
        var userName = document.querySelector('#userName').value;

        //잘 코드가 작성 되었는지 확인하기
        /* console.log(userid);
        console.log(pw);
        console.log(repw);
        console.log(userName); */

        

        //입력 받은 아이디의 좌우 공백을 없애주기
        if (userid.trim().length < 1) {
            alert('아이디를 입력해 주세요.');
            return false;
        }
        if (pw.trim().length < 1 || repw.trim().length < 1) {
            alert('비밀번호를 입력해 주세요.');
            return false;
        }
        //비밀번호 일치 여부 체크하기
        if (pw.trim() != repw.trim()) {
            alert('비밀번호가 일치하지 않습니다. \n다시 입력해 주세요.');
            return false;
        }

        //잘 코드가 작성 되었는지 확인하기
        console.log(userid);
        console.log(pw);
        console.log(repw);
        console.log(userName);
         
        var member = new Member(userid, pw, userName);
        console.log(typeof member, member.makeHtml());

        return false;
    }
}