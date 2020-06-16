// 사용자 입력 폼 Casting
// 기본적인 유효성 검사

// <form> casting
// onsubmit

var form = document.getElementById('loginform');

form.setAttribute('action', 'http://www.naver.com');


// onsubmint
form.onsubmit = function() {
    // <input> casting
    var uid = document.getElementById('id');
    var upw = document.getElementById('pw');

    if(uid.value==null || uid.value.length<1){
        alert('아이디 정보를 입력해주세요.');
        uid.focus();
        return false;
    }

    if(upw.value==null || upw.value.length<1){
        alert('비밀번호 정보를 입력해주세요.');
        upw.focus();
        return false;
    }

}
