

// 회원의 정보 : 아이디, 비밀번호, 이름
// Member -> 생성자 함수를 정의
function Member(id, pw, name){
    this.userId=id;
    this.pw=pw;
    this.userName=name;
}
// 객체가 가지는 메소드는 공통으로 사용 -> prototype
Member.prototype.makeHtml = function (){
    return '[id:'+this.userId+' , pw: '+this.pw+' , name: '+this.userName+' ]'
};


//////////////////////////////////////////////////////////

// 사용자 입력한 정보를 가지고 Member객체를 생성
// submit  이벤트 연결

window.onload = function () {

    /* // 사용자가 입력한 값 
    var userid = document.querySelector('#userID').value;
    var pw = document.querySelector('#pw').value;
    var repw = document.querySelector('#repw').value;
    var userName = document.querySelector('#userName').value; */
    
    //value 개선하기
    var userid = document.querySelector('#userID');
    var pw = document.querySelector('#pw');
    var repw = document.querySelector('#repw');
    var userName = document.querySelector('#userName');

    // regForm 캐스팅
    var regForm = document.getElementById('regForm');
    regForm.onsubmit = function(){


        if(userid.value.trim().length < 1) {
            // alert('아이디를 입력해주세요');
            //메시지 캐스팅하기 (동위선택자 활용)
            document.querySelector('#userID+div.msg').innerHTML = '필수항목입니다.'
            document.querySelector('#userID+div.msg').style.display='block';
            return false;
        }
        if(pw.value.trim().length < 1) {
            document.querySelector('#pw+div.msg').innerHTML = '필수항목입니다.'
            document.querySelector('#pw+div.msg').style.display='block';
            return false;
        }
        if(repw.value.trim().length < 1) {
            document.querySelector('#repw+div.msg').innerHTML = '필수항목입니다.'
            document.querySelector('#repw+div.msg').style.display='block';
            return false;
        }
        if(pw.value.trim() != repw.trim()) {
            document.querySelector('#repw+div.msg').innerHTML = '비밀번호가 일치하지 않습니다..'
            document.querySelector('#repw+div.msg').style.display='block';
            return false;
        }
        if(userName.value.trim().length < 1) {
            document.querySelector('#userName+div.msg').innerHTML = '필수항목입니다.'
            document.querySelector('#userName+div.msg').style.display='block';
            return false;
        }
        
        //커서를 넣으면 빨간 글씨 없어지게 하기 --> 다른 범위에 입력하기 (onsubmit 밑으로 이사)
        /* userid.addEventListener('focus', function(){
            document.querySelector('#userID+div.msg').style.display='none';
        }); */

        if(pw.value.trim().length<1 ){
            alert('비밀번호를 입력해주세요');
            return false;
        }
        if(repw.trim().length<1 ){
            alert('비밀번호를 입력해주세요');
            return false;
        }
        
        // 비밀번호 비밀번호 확인 일치 여부 체크
        if(pw.value.trim() != repw.trim()) {
            alert('비밀번호와 비밀번화 확인과 일치하지 않습니다.\n다시 확인해주세요.')
            return false;
        }
        if(userName.value.trim().length < 1) {
            alert('이름을 입력해주세요');
            return false;
        }
        console.log(userid.value);
        console.log(pw.value);
        console.log(repw.value);
        console.log(userName.value);

        /* var member = new Member(userid.value, pw.value,  userName.value);
        console.log(typeof member, member.makeHtml());
 */

        //배열에 사용자 정보를 추가
        members.push(new Member(userid.value, pw.value,  userName.value));
        alert('등록 되었습니다.')

        console.log('회원리스트', members);

        //등록 누른 후 입력란들 모두 리셋해주기
        
        return false;
    }

    //text 박스에 커서를 넣으면 빨간 글씨 없어지게 하기
    userid.addEventListener('focus', function(){
        document.querySelector('#userID+div.msg').style.display='none';
        document.querySelector('#userID+div.msg').innerHTML='';
        userid.value='';
    });
    pw.addEventListener('focus', function(){
        document.querySelector('#pw+div.msg').style.display='none';
        document.querySelector('#pw+div.msg').innerHTML='';
        userid.value='';
    });
    repw.addEventListener('focus', function(){
        document.querySelector('#repw+div.msg').style.display='none';
        document.querySelector('#repw+div.msg').innerHTML='';
        userid.value='';
    });
    userName.addEventListener('focus', function(){
        document.querySelector('#userName+div.msg').style.display='none';
        document.querySelector('#userName+div.msg').innerHTML='';
        userid.value='';
    });
}


