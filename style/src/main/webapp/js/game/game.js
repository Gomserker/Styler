

function call(date) {

    

    var today = new Date();

    var year = today.getFullYear();
    var month = ('0' + (today.getMonth() + 1)).slice(-2);
    var day = ('0' + today.getDate()).slice(-2);

    var dateString = year + '/' + month + '/' + day;

    console.log(dateString);
    console.log(date);

	if(date == ""){
		alert("로그인 하신 후에 출석체크가 가능합니다.");
        return false;
	}
    if (date == dateString) {
        alert("출석체크는 하루에 한번만 가능합니다.");
        return false;
    }

    alert("("+dateString+")"+" 출석체크 되셨습니다.");
    return true;

}