let name1 = document.form.name1;
let id = document.form.id;
let pw = document.form.pw;
let pwCheck = document.form.pwCheck;
let gender = document.form.gender;
let email = document.form.email;
let style = document.form.style;
let profileImg = document.form.profileImg;
let typeOfManager = document.form.typeOfManager;
let checkPoint = document.form.checkPoint;
let nickname = document.form.nickname;



function isEmpty(input) {

	return !input.value;  //값이 없어서 거짓.

}

// <input>이랑 글자 수를 넣으면 그 글자수 보다 적으면 참, 아니면 거짓


function lessThan(input, length) {

	return input.value.length < length;
}

function moreThan(input, length) {
	return input.value.length > length;
}

//인풋을 넣으면
//한글/특수문자 들어있으면 참, 아니면 거짓

function containKr(input) {
	// 엠지
	//input.value = 'q지';

	let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@._/";

	for (let i = 0; i < input.value.length; i++) {

		if (ok.indexOf(input.value[i]) == -1) {
			return true;

		}

	}
}

//input 데이터 2개 넣으면 내용이 다르면 true 아니면 false
function equalData(input1, input2) {
	return !(input1.value == input2.value)
}

//<input> 문자열 세트
// 그 문자열 세트가 포함 안되었으면 true
// 들어있으면 false

function notContains(input, set) {
	//input : 1qwerASD
	// set: 1234567890 숫자를 반드시 포함

	for (let i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1)
			return false;
	}
	return true;
}

//체크박스 체크여부
function notCheck(input) {
	if (input.checked) {
		return false;
	}
	return true;
}

//<input>을 넣어서 
// 숫자가 아니면 true, 숫자면 false
function isNotNumber(input) {
	return isNaN(input.value);
}

//xxx(photoInput, "jpg")
//그게 아니면 true, 아니면 false
function isNotType(input, type) {
	type = "." + type; //.jpg

	return input.value.indexOf(type) == -1; //input에.jpg가 있나 없나
}

//특수문자 체크
//if(pattern_spc.test(str))
var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자



//실제로쓸때 input.value <<이렇게 써야됨
// 한글 체크 
function checkKor(str) { const regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g; if (regExp.test(str)) { return true; } else { return false; } }

// 숫자 체크 
function checkNum(str) { const regExp = /[0-9]/g; if (regExp.test(str)) { return true; } else { return false; } }

// 영문(영어) 체크 
function checkEng(str) {
	const regExp = /[a-zA-Z]/g;
	// 영어 
	if (regExp.test(str)) { return true; } else { return false; }
}

// 영문+숫자만 입력 체크
function checkEngNum(str) { const regExp = /[a-zA-Z0-9]/g; if (regExp.test(str)) { return true; } else { return false; } }

// 공백(스페이스 바) 체크
function checkSpace(str) {
	if (str.search(/\s/) !== -1) {
		return true;
		// 스페이스가 있는 경우
	} else {
		return false; // 스페이스 없는 경우
	}
}

//아이디 체크
function CheckID(uid) {
	if (!/^[a-zA-Z0-9]{8,20}$/.test(uid)) {
		alert("아이디는 숫자와 영문자 조합으로 8~20자리를 사용해야 합니다.");
		return true;
	}
	var chk_num = uid.search(/[0-9]/g);
	var chk_eng = uid.search(/[a-z]/ig);

	if (chk_num < 0 || chk_eng < 0) {
		alert("아이디는 숫자와 영문자를 혼용하여야 합니다.");
		return true;
	}
	if (/(\w)\1\1\1/.test(uid)) {
		alert("아이디에 같은 문자를 4번 이상 사용하실 수 없습니다.");
		return true;
	}

	return false;
}


//비밀번호체크
function CheckPassword(upw) {
	if (!/^[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,20}$/.test(upw)) {
		alert("비밀번호는 숫자와 영문자 조합으로 8~20자리를 사용해야 합니다.");
		return true;
	}
	var chk_num = upw.search(/[0-9]/g);
	var chk_eng = upw.search(/[a-z]/ig);
	var chk_special = upw.search(/[!?@#$%^&*():;+-=~{}<>\_\[\]\|\\\"\'\,\.\/\`\₩]/g);
	if (chk_num < 0 || chk_eng < 0 || chk_special < 0) {
		alert("비밀번호는 숫자와 특수문자+영문자를 혼용하여야 합니다.");
		return true;
	}
	if (/(\w)\1\1\1/.test(upw)) {
		alert("비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.");
		return true;
	}

	return false;
}

//윗값과 같은지 확인
function equalCheck(input1, input2) {
	if (input1.value != input2.value) {
		return true;
	}
	return false;
}


function call() {
	//이름: 빈칸x 한글 공백x 30자미만
	if (isEmpty(name1) || moreThan(name1, 30) || checkSpace(name1.value) || checkEng(name1.value) || (pattern_spc.test(name1.value))) {
		alert("이름을 확인해주세요.");
		name1.value = "";
		name1.focus();
		return false;
	}

	//중복아이디확인
	//아이디: 빈칸x 영어+숫자 공백x 20자미만
	if (isEmpty(id) || lessThan(id, 7) || moreThan(id, 20) || CheckID(id.value) || checkSpace(id.value)) {
		alert("아이디를 확인해 주세요");
		id.value = "";
		id.focus();
		return false;
	}


	//비밀번호: 빈칸x 영어+숫자+특수문자 + 공백x 8자이상
	if (isEmpty(pw) || lessThan(pw, 8) || checkSpace(pw.value) || checkKor(pw.value) || CheckPassword(pw.value)) {
		alert("비밀번호를 확인해 주세요");
		pw.value = "";
		pw.focus();
		return false;
	}
	//비밀번호확인
	if (equalCheck(pw, pwCheck)) {
		alert("상위의 비밀번호와 동일한 값을 입력해 주세요.");
		pwCheck.value = "";
		pwCheck.focus();
		return false;
	}
	//닉네임: 빈칸x 한글+영어+숫자 공백x 10자~20자
	if (isEmpty(nickname) || lessThan(nickname, 2) || moreThan(nickname, 20) || checkSpace(nickname.value) || (pattern_spc.test(nickname.value))) {
		alert("닉네임을 확인해 주세요");
		nickname.value = "";
		nickname.focus();
		return false;
	}
	//성별: 빈칸x
	if (isEmpty(gender)) {
		alert("성별을 체크해 주세요");
		return false;
	}
	//이메일: @포함, 빈칸x,영어숫자 공백x 50자미만
	if (isEmpty(email) || checkSpace(email.value) || checkKor(email.value) || moreThan(email, 50) || notContains(email, "@")) {
		alert("이메일을 확인해주세요");
		email.value = "";
		email.focus();
		return false;
	}
	//옷취향: 빈칸x
	if (isEmpty(email)) {
		alert("옷취향을 체크해 주세요");
		return false;
	}
	//프사: jpg, png, 빈칸x 
	if ((isNotType(profileImg, "jpg") && isNotType(profileImg, "png") && isNotType(profileImg, "PNG") && isNotType(profileImg, "JPG")) || isEmpty(profileImg)) {
		alert("프로필사진을 등록해주세요.");
		return false;
	}
	//체크1:빈칸x
	if (notCheck(typeOfManager)) {
		alert("제1약관에 동의해 주세요.");
		return false;
	}
	//체크2:빈칸x
	if (notCheck(checkPoint)) {
		alert("제2약관에 동의해 주세요.");
		return false;
	}

	alert("회원가입 되셨습니다! 환영합니다:)");
	return true;
}