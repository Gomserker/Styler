//xxx(photoInput, "jpg")
//그게 아니면 true, 아니면 false
function isNotType(input, type) {
	type = "." + type; //.jpg

	return input.value.indexOf(type) == -1; //input에.jpg가 있나 없나
}

function isEmpty(input) {

	return !input.value;  //값이 없어서 거짓.

}

let profileImg = document.form.img;

function call(){
    //프사: jpg, png, 빈칸x 
	if ((isNotType(profileImg, "jpg") && isNotType(profileImg, "png") && isNotType(profileImg, "PNG") && isNotType(profileImg, "JPG")) || isEmpty(profileImg)) {
		alert("프로필사진을 등록해주세요.");
		return false;
	}
}