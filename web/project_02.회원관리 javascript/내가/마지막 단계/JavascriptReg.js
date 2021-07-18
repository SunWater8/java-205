//1-1. member 생성자 함수 정의하기
function Member(id, pw, name) {
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}
//1-2. prototype - console에 이 형태로 출력 (toString 같은 역할)
Member.prototype.makeHtml = function () {
    return '[id: ' + this.userId + ' , pw: ' + this.pw + ', name: ' + this.userName + ']'
};

// 2-1 회원정보 저장하는 배열
var members = [];

//1-3.사용자가 입력한 정보로 Member 객체 생성하기
window.onload = function () {
    // 6-1 localStorage 저장된 데이터가 있는지 확인, 없다면 members 배열을 JSON에다가 저장-----------------------------------
    if(localStorage.getItem('members')==null){
        localStorage.setItem('members', JSON.stringify(members));
    }else{
        members = JSON.parse(localStorage.getItem('members'));
        console.log(members);
        // setList함수 여기로 옮겨 오기
        setList();
    }
    
    // 3-2 setlist 함수 호출 
    // setList()    6-1에서 자기 영역으로 가져감.
    
    //1-4. 사용자가 입력한 값
    //  2-2 onsubmit 함수 위로 이동
    // 2-3 value 지우기
    var userid = document.querySelector('#userID');
    var pw = document.querySelector('#pw');
    var repw = document.querySelector('#repw');
    var userName = document.querySelector('#userName');

    var regForm = document.getElementById('regForm');

    regForm.onsubmit = function () {


        //1-5. 아이디, 비밀번호, 이름 좌우공백 없애고 입력을 잘 했는지 체크하기
        //2-4 경고문 아래에 뜨도록 개선-(innerHTML, style.display 설정)
        if (userid.value.trim().length < 1) { //2-5 조건문에 value 추가
            document.querySelector('#userID+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userID+div.msg').style.display = 'block';
            // alert('이름을 입력해 주세요.'); 
            return false;
        }

        if (pw.value.trim().length < 1) {
            document.querySelector('#pw+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#pw+div.msg').style.display = 'block';
            return false;
        }
        if (repw.value.trim().length < 1) {
            document.querySelector('#repw+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#repw+div.msg').style.display = 'block';
            return false;
        }
        //1-6비밀번호 일치 여부 확인하기
        if (pw.value.trim() != repw.value.trim()) {
            document.querySelector('#repw+div.msg').innerHTML = '비밀번호가 일치하지 않습니다.';
            document.querySelector('#repw+div.msg').style.display = 'block';
            return false;
        }

        if (userName.value.trim().length < 1) {
            document.querySelector('#userName+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userName+div.msg').style.display = 'block';
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

        //6-2 저장------------------------------------------------------------------------
        localStorage.setItem('members', JSON.stringify(members));
        
        alert('등록되었습니다.');
        console.log('회원리스트', members);

        // 2-7 reset메소드 추가
        this.reset();
        //3-3 setlist 함수 호출
        setList();
        return false;
    }

    // 2-8입력박스를 클릭하면 빨간 경고문 없애기
    userid.addEventListener('focus', function () {
        document.querySelector('#userID+div.msg').style.display = 'none';
        document.querySelector('#userID+div.msg').innerHTML = '';
    });
    pw.addEventListener('focus', function () {
        document.querySelector('#pw+div.msg').style.display = 'none';
        document.querySelector('#pw+div.msg').innerHTML = '';
    });
    repw.addEventListener('focus', function () {
        document.querySelector('#repw+div.msg').style.display = 'none';
        document.querySelector('#repw+div.msg').innerHTML = '';
    });
    userName.addEventListener('focus', function () {
        document.querySelector('#userName+div.msg').style.display = 'none';
        document.querySelector('#userName+div.msg').innerHTML = '';
    });

}


//  3-1 setlist 함수 만들기 - 배열의 요소를 table에 추가하기
function setList() {

    // 6-7 콘솔에 멤버배열 출력
    console.log(members);
    var list = document.querySelector('#list');

    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디(이메일)</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';

    // var tbody=list.innerHTML;

    if (members.length < 1) {
        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 존자해지 않습니다.</td>'
        tbody += '</tr>';

    } else {
        for(var i=0;i<members.length;i++){

            tbody += '<tr>';
            tbody += '  <td>'+i+'</td>';
            tbody += '  <td>'+members[i].userId+'</td>';
            tbody += '  <td>'+members[i].pw+'</td>';
            tbody += '  <td>'+members[i].userName+'</td>';
            //5-2 tbody += '  <th>수정 | 삭제</th>';
            tbody += '  <th><a href="javascript:editMember('+i+')">수정</a> | <a href="javascript:deleteMember('+i+')">삭제</a></th>';
            tbody += '</tr>';
        }
    }
    list.innerHTML = tbody;

}

// 4-1 배열의 요소 삭제 함수
function deleteMember(index){
    if(confirm('삭제하시겠습니까')){
        members.splice(index,1);
        alert('삭제되었습니다');
        //6-3 저장----------------------------------------------------------------------------
        localStorage.setItem('members', JSON.stringify(members));
        setList();
    }
}

//5-1배열의 요소 수정 함수 개선 
function editMember(index){

    document.querySelector('#editFormArea').style.display='block';

    console.log(index, members[index]);

    var editUserId = document.querySelector('#editId');
    var editPw = document.querySelector('#editPw');
    var editRePw = document.querySelector('#editRePw');
    var editName = document.querySelector('#editName');
    var editIndex = document.querySelector('#index');

    editUserId.value = members[index].userId;
    editPw.value = members[index].pw;
    editRePw.value = members[index].pw;
    editName.value = members[index].userName;
    editIndex.value = index;

    document.querySelector('#editForm').onsubmit=function(){
        if(editPw.value != editRePw.value){
               alert('비밀번호가 일치하지 않습니다.');
            return false;
        }

        if(!confirm('수정하시겠습니까?')){
            return false;
        }

        members[editIndex.value].pw = editPw.value;
        members[editIndex.value].userName = editName.value;

        //6-4 저장----------------------------------------------------------------------------
        localStorage.setItem('members', JSON.stringify(members));
        alert('수정 되었습니다.');
        
        setList();

        //6-6 닫기 -------------------------------------------------------------------------------
        editMemberClose();

        return false;
    }
    
}
//6-5 닫는 함수
function editMemberClose(){
    document.querySelector('#editFormArea').style.display = 'none';
}