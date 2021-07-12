//  제이쿼리로 바꿔보기

//1-1. member 생성자 함수 정의하기
function Member(id, pw, name) {
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}
//1-2. prototype
Member.prototype.makeHtml = function () {
    return '[id: ' + this.userId + ' , pw: ' + this.pw + ', name: ' + this.userName + ']'
};

// 2-1 회원정보 저장하는 배열
var members = [];

window.onload = function () {
    // 6-1 localStorage 저장된 데이터가 있는지 확인, 없다면 members 배열을 JSON에다가 저장-----------------------------------
    if(localStorage.getItem('members')==null){
        localStorage.setItem('members', JSON.stringify(members));
    }else{
        members = JSON.parse(localStorage.getItem('members'));
        console.log(members);
        // setList함수 여기로 옮겨 오기
        // setList();
    }
    var userid = document.querySelector('#userID');
    var pw = document.querySelector('#pw');
    var repw = document.querySelector('#repw');
    var userName = document.querySelector('#userName');

    var regForm = document.getElementById('regForm');

    $(document).ready(function(){
        
        if(userid.value.trim().length < 1) {
            $('#userID+div.msg').html('필수항목입니다.').appendTo('body');
            $('#userID+div.msg').css('display','block');
        }
    });
    console.log(userid.value);


    
    
}

//setList 함수
function setList(){
    $(document).ready(function(){
        // var list = $('#list');

        $('th').html('순번');
        $('th').html('아이디');
        $('th').html('비밀번호');
        $('th').html('이름');
        $('th').html('관리');
    });
}