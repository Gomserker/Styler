function delAccount(id){
	
let ok = confirm('잠깐!! 정말 탈퇴하시려구요?\n탈퇴 시 작성했던 모든 게시글과 댓글이 삭제되며 재가입 시에도\n복구되지 않습니다.');
		

if(ok){
	location.href='SignOutC?id=' +id;
	}
}