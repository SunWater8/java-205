//생성자
function Member(id, pw, name) {
    this.userID = id;
    this.pw = pw;
    this.userName = name;
}
//prototype
Member.prototype.makeHtml = function () {
    return '[id: ' + this.userId + ' , pw: ' + this.pw + ', name: ' + this.userName + ']'
};
//입력받아 저장할 배열
var members = [];

$(document).ready(function () {
    //저장소
    if (localStorage.getItem('members') == null) {
        localStorage.setItem('members', JSON.stringify(members));
    } else {
        members = JSON.parse(localStorage.getItem('members'));
        console.log(members);
        setList();
    }

    var userid = $('#userID');
    var pw = $('#pw');
    var repw = $('#repw');
    var userName = $('#userName');

    $('#regForm').submit(function () {

        // Form 의 유효성 검사
        //아이디의 공백문자 확인 
        if (userid.val().trim().length < 1) {
            $('#userID+div.msg').html('<p>필수항목입니다.</p>');
            $('#userID+div.msg').css('display', 'block');
            return false;
        } else { //이메일 입력양식 제한
            var emailExp = /\w+@\w+\.\w+/;
            if (!emailExp.test($(userid).val().trim())) {
                $('#userID + div.msg').html('이메일 형식에 맞게 입력해 주세요');
                $('#userID + div.msg').css('display', 'block');
                return false;
            }
        }
        //비밀번호의 공백문자 확인
        if (pw.val().trim().length < 1) {
            $('#pw+div.msg').html('<p>필수항목입니다.</p>');
            $('#pw+div.msg').css('display', 'block');
            return false;
        } else {
            //비밀번호의 입력양식 제한
            var pwExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[~!@#$%^&*<>?]).{8,30}$/i;
            if (!pwExp.test($(pw).val().trim())) {
                $('#pw+div.msg').html('<p>영어, 숫자, 특수기호 모두를 포함해서 8~30자리 입력해 주세요.</p>')
                $('#pw+div.msg').css('display', 'block');
                return false;
            }
        }
        //비밀번호(확인)의 공백문자 확인
        if (repw.val().trim().length < 1) {
            $('#repw+div.msg').html('<p>필수항목입니다.</p>');
            $('#repw+div.msg').css('display', 'block');
            return false;
        }
        //이름의 공백문자 확인.
        if (userName.val().trim().length < 1) {
            $('#userName+div.msg').html('<p>필수항목입니다.</p>');
            $('#userName+div.msg').css('display', 'block');
            return false;
        } else { //이름의 한글입력 제한
            var nameExp = /^[가-힣]+$/;
            if (!nameExp.test($(userName).val().trim())) {
                $('#userName+div.msg').html('<p>한글을 입력해 주세요.</p>');
                $('#userName+div.msg').css('display', 'block');
                return false;
            }
        }
        //비밀번호 일치 여부 확인하기
        if (pw.val().trim() != repw.val().trim()) {
            $('#repw+div.msg').html('<p>비밀번호가 일치하지 않습니다.</p>');
            $('#repw+div.msg').css('display', 'block');
            return false;
        }
        // value 추가   
        members.push(new Member(userid.val(), pw.val(), userName.val()));

        // 저장
        localStorage.setItem('members', JSON.stringify(members));

        alert('등록되었습니다.');
        console.log('회원리스트', members);

        this.reset();
        setList();
        return false;
    });

    //클릭하면 메시지 안보이게 동작하기
    $(userid).focus(function () {
        $('#userID+div.msg').css('display', 'none');
        $('#userID+div.msg').html('');
    });
    $(pw).focus(function () {
        $('#pw+div.msg').css('display', 'none');
        $('#pw+div.msg').html('');
    });
    $(repw).focus(function () {
        $('#repw+div.msg').css('display', 'none');
        $('#repw+div.msg').html('');
    });
    $(userName).focus(function () {
        $('#userName+div.msg').css('display', 'none');
        $('#userName+div.msg').html('');
    });
});

function setList() {
    var list = $('#list');

    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디(이메일)</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';

    if (members.length < 1) {
        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 존자해지 않습니다.</td>'
        tbody += '</tr>';

    } else {
        for (var i = 0; i < members.length; i++) {

            tbody += '<tr>';
            tbody += '  <td>' + i + '</td>';
            tbody += '  <td>' + members[i].userID + '</td>';
            tbody += '  <td>' + members[i].pw + '</td>';
            tbody += '  <td>' + members[i].userName + '</td>';
            tbody += '  <th><a href="javascript:editMember(' + i + ')">수정</a> | <a href="javascript:deleteMember(' + i + ')">삭제</a></th>';
            tbody += '</tr>';
        }
    }
    $(list).html(tbody);

}
function deleteMember(index) {
    if (confirm('삭제하시겠습니까')) {
        members.splice(index, 1);
        alert('삭제되었습니다');
        //저장
        localStorage.setItem('members', JSON.stringify(members));
        setList();
    }
}

function editMember(index) {

    $('#editFormArea').css('display', 'block');
    $('#editId').val(members[index].userid);
    $('#editPw').val(members[index].pw);
    $('#editRePw').val(members[index].pw);
    $('#editName').val(members[index].userName);
    $('#index').val(index);

    $('#editForm').submit(function () {

        var pwExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[~!@#$%^&*<>?]).{8,30}$/i;
        if (!pwExp.test($('#editPw').val().trim())) {
            alert('<p>영어, 숫자, 특수기호 모두를 포함해서 8~30자리 입력해 주세요</p>')
            return false;
        }
        var nameExp = /^[가-힣]+$/;
        if (!nameExp.test($('#editName').val().trim())) {
            alert('<p>한글을 입력해 주세요.</p>');
            return false;
        }
        //비밀번호 일치 여부 확인하기
        if ($('#editPw').value != $('#editRePw').value) {
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }

        if (!confirm('수정하시겠습니까?')) {
            return false;
        }

        members[$('#editIndex').val()].pw = $('#editPw').value;
        members[$('#editIndex').val()].userName = $('#editName').value;
        // 저장
        localStorage.setItem('members', JSON.stringify(members));
        alert('수정 되었습니다.');
        setList();

        editMemberClose();
        return false;
    });
}
function editMemberClose() {
    $('#editFormArea').css('display', 'none');
}