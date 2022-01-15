function needLogin(n,p) {
	
	
	
	//const ok = confirm("정말 삭제하실 거에요?");

	if (p.length < 1) {
		alert('로그인이필요합니다');
		
		return false;
	}
	else{
		
		location.href='DailyAddLikeController?no='+n+'&mynick='+p
	}
}