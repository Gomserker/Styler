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
	function equalData(input1, input2){
	    return !(input1.value == input2.value)
	}

	//<input> 문자열 세트
	// 그 문자열 세트가 포함 안되었으면 true
	// 들어있으면 false

	function notContains(input, set){
	    //input : 1qwerASD
	    // set: 1234567890 숫자를 반드시 포함
	    
	    for(let i = 0; i < set.length; i++){
	        if(input.value.indexOf(set[i])!= -1)
	        return false;
	    }
	    return true;
	}

	   //<input>을 넣어서 
	    // 숫자가 아니면 true, 숫자면 false
	function isNotNumber(input){
	        return isNaN(input.value);
	}

	//xxx(photoInput, "jpg")
	//그게 아니면 true, 아니면 false
	function isNotType(input, type){
		type = "." + type; //.jpg
		
		return input.value.indexOf(type) == -1; //input에.jpg가 있나 없나
	}
	
	//전역변수
	let id = document.form.id;
	let pw = document.form.pw;
	
	function call() {

		

		if (isEmpty(id)) {
			id.value = "";
			id.focus();
			alert('아이디를 확인해 주세요.');
			return false;
		}

		if (isEmpty(pw)) {
			pw.value = "";
			pw.focus();
			alert('비밀번호를 확인해 주세요.');
			return false;
		}
		return true;

	}