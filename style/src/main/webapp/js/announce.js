function AdelCheck1(no){
let ok = confirm('정말 삭제합니까?');

if(ok){
	location.href='AnnounceDeleteController?no=' +no;
}
	
}
function commentDelCheck1(cno,pno){
let ok = confirm('정말 삭제합니까?');

if(ok){
	location.href='AnnounceCommentDeleteController?cno='+cno+"&no="+pno ;
}
	
}
