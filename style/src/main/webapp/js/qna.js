function delCheck2(no){
let ok = confirm('정말 삭제합니까?');

if(ok){
	location.href='QnaDeleteController?no=' +no;
}
	
}
function commentDelCheck2(cno,pno){
let ok = confirm('정말 삭제합니까?');

if(ok){
	location.href='QnaCommentDeleteController?cno='+cno+"&no="+pno ;
}
	
}
