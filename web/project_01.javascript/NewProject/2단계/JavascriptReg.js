//1-1. member 생성자 함수 정의하기
function Member(id, pw, name){
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}
//1-2. prototype
Member.prototype.makeHtml = function(){
    return '[id: '+this.userId+' , pw: '+this.pw+', name: '+this.userName+']'
};

// 2-1 회원정보 저장하는 배열--------------------------------------------------------
var members = [];

//1-3.사용자가 입력한 정보로 Member 객체 생성하기
 window.onload = function(){
     
     //1-4. 사용자가 입력한 값
    //  2-2 onsubmit 함수 위로 이동------------------------------------------------
    // 2-3 value 지우기
     var userid = document.querySelector('#userID');
     var pw = document.querySelector('#pw');
     var repw = document.querySelector('#repw');
     var userName = document.querySelector('#userName');

     var regForm = document.getElementById('regForm');

     regForm.onsubmit = function(){


        //1-5. 아이디, 비밀번호, 이름 좌우공백 없애고 입력을 잘 했는지 체크하기
        //2-4 경고문 아래에 뜨도록 개선-(innerHTML, style.display 설정)-----------------
        if(userid.value.trim().length<1){ //2-5 조건문에 value 추가
            document.querySelector('#userID+div.msg').innerHTML='필수항목입니다.';
            document.querySelector('#userID+div.msg').style.display='block';
            // alert('이름을 입력해 주세요.'); 
            return false;
        }
        
        if(pw.value.trim().length<1 ){
            document.querySelector('#pw+div.msg').innerHTML='필수항목입니다.';
            document.querySelector('#pw+div.msg').style.display='block';
            return false;
        }
        if( repw.value.trim().length<1){
            document.querySelector('#repw+div.msg').innerHTML='필수항목입니다.';
            document.querySelector('#repw+div.msg').style.display='block';
            return false;
        }
        //1-6비밀번호 일치 여부 확인하기
        if(pw.value.trim() != repw.value.trim()){
            document.querySelector('#repw+div.msg').innerHTML='비밀번호가 일치하지 않습니다.';
            document.querySelector('#repw+div.msg').style.display='block';
            return false;
        }
        
        if(userName.value.trim().length<1){
            document.querySelector('#userName+div.msg').innerHTML='필수항목입니다.';
            document.querySelector('#userName+div.msg').style.display='block';
            return false;
        }


        
        // 1-7 콘설에서 가입 정보 확인
        console.log(userid.value);
        console.log(pw.value);
        console.log(repw.value);
        console.log(userName.value);
        // console.log(userid.value, pw.value, repw.value, userName.value); 
        //2-6 value 추가   
        members.push(new Member(userid.value, pw.value, userName.value));

        alert('등록되었습니다.');
        console.log('회원리스트', members);

        // 2-7 reset메소드 추가
        this.reset();
        return false;
    }

    // 2-8입력박스에 클릭하면 빨간 경고문 없애기
    userid.addEventListener('focus', function(){
        document.querySelector('#userID+div.msg').style.display = 'none';
        document.querySelector('#userID+div.msg').innerHTML = '';
    });
    pw.addEventListener('focus', function(){
        document.querySelector('#pw+div.msg').style.display = 'none';
        document.querySelector('#pw+div.msg').innerHTML = '';
    });
    repw.addEventListener('focus', function(){
        document.querySelector('#repw+div.msg').style.display = 'none';
        document.querySelector('#repw+div.msg').innerHTML = '';
    });
    userName.addEventListener('focus', function(){
        document.querySelector('#userName+div.msg').style.display = 'none';
        document.querySelector('#userName+div.msg').innerHTML = '';
    });
     



    
 }

