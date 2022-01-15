function delCheck(no){
let ok = confirm('정말 삭제합니까?');

if(ok){
	location.href='FreeDeleteController?no=' +no;
}
	
}
function commentDelCheck(cno,pno){
let ok = confirm('정말 삭제합니까?');

if(ok){
	location.href='CommentDeleteController?cno='+cno+"&no="+pno ;
}
	
}
