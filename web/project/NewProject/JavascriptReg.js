//member 생성자 함수 정의하기
function Member(id, pw, name){
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}
//prototype
Member.prototype.makeHtml = function(){
    return '[id: '+this.userId+' , pw: '+this.pw+', name: '+this.userName+']'
};

//사용자가 입력한 정보로 Member 객체 생성하기
 window.onload = function(){

    var regForm = document.getElementById('regForm');
    regForm.onsubmit = function(){

        //사용자가 입력한 값
        var userid = document.querySelector('#userID').value;
        var pw = document.querySelector('#pw').value;
        var repw = document.querySelector('#repw').value;
        var userName = document.querySelector('#userName').value;

        //아이디, 비밀번호, 이름 좌우공백 없애고 입력을 잘 했는지 체크하기
        if(userid.trim().length<1){
            alert('이름을 입력해 주세요.'); 
            return false;
        }

        if(pw.trim().length<1 || repw.trim().length<1){
            alert('비밀번호를 입력해 주세요.');
            return false;
        }
        if(userName.trim().length<1){
            alert('이름을 입력해 주세요.');
            return false;
        }
        //비밀번호 일치 여부 확인하기
        if(pw.trim() != repw.trim()){
            alert('비밀번호가 일치하지 않습니다.')
            return false;
        }
        
        console.log(userid, pw, repw, userName);    
        
        var member = new Member(userid, pw, userName);

        console.log(Member, Member.prototype.makeHtml);
        return false;
    }
     
 }

