function deleteReview(n) {
	const ok = confirm("정말 삭제하실 거에요?");

	if (ok) {
		location.href = "DeletePost?no=" + n;
	}
}

const like = document.querySelector(".like i");

function pressLike() {
	like.classList.toggle("active");
}

function reviewCommentDelCheck(cno,pno){
let ok = confirm("정말 삭제하실 거에요?");

if(ok){
	location.href='ReviewCommentDeleteC?cno='+cno+"&no="+pno ;
}
	
}