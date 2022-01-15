<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<h1>공지게시판</h1>  

	<hr>
	<table class="table table-borderless" style="width: 95%; margin: auto " border="2">
		<tr>
			<td class="h5 ps-3 border-bottom" colspan="4">${p.p_title}</td>
		</tr>

		<tr>
			<td  class="ps-3" colspan="2" style="text-align: auto"> <small> ${p.p_user} </small> | <small class="text-muted"> <fmt:formatDate value="${p.p_date}" pattern="yyyy.MM.dd / a hh:mm"/> </small> </td>
			<td colspan="2" style="text-align: center"> <small>조회수 ${p.p_view_count}</small> <small>|</small> <small>댓글수 ${totalComment}</small>
			</td>
		</tr>
		<tr>
			<td class="ps-3 border" colspan="4"> <img src=" announce/img/${p.p_img}"> <br>${p.p_text} </td>
			
		</tr>
		
<c:set var="writerName" value="${p.p_user}" />
<c:set var="loginName" value="${sessionScope.accountInfo.nickname}" />



		<c:if
			test="${sessionScope.accountInfo.typeOfManger eq '다이아'}">
			<tr>
				<td colspan="4"><hr class=""></td>
			</tr>

			<tr>
				<td colspan="3"></td>
				<td style="text-align: center">
					<button class="btn btn-secondary"
						onclick="location.href='AnnounceModifyController?no=${p.p_no}'">수정-관리자</button>
					<button class="btn btn-danger" onclick="AdelCheck1(${p.p_no})">삭제-관리자</button>
				</td>
			</tr>
		</c:if>
		
		
		<tr>
		<td colspan="4"><hr class=""></td>
		</tr>
		
	  <c:forEach var="c" items="${comments}" >
		<tr>
		<td>
		<%-- <table class="table">
		<tr> <td> ${c.c_users} </td>
			<td> ${c.c_text} </td>
		
		    <td> <fmt:formatDate value="${c.c_date}" pattern="yyyy.MM.dd/ a hh:mm"/></td>
		    <td> 수정 삭제  </td> 
		    </tr>
		</table> --%>
		<div class="border-bottom">
		<div> <small> ${c.c_users} </small></div>
		<div>${c.c_text}</div>
		<div><small class="text-muted"><fmt:formatDate value="${c.c_date}" pattern="yyyy.MM.dd/ a hh:mm"/></small></div>
		
		<c:set var="Cuser" value="${c.c_users }"></c:set>
		<c:choose>
		<c:when test="${fn:trim(Cuser) eq sessionScope.accountInfo.nickname}">  
		<div class="btn-group  btn-group-sm mt-2"> 
		<button class="btn btn-outline-secondary" data-bs-toggle="collapse" data-bs-target="#check${c.c_no}" aria-expanded="false" aria-controls="수정">수정</button>
		 <button class="btn btn-outline-danger" onclick="commentDelCheck1(${c.c_no},${p.p_no})" >삭제</button>
		   </div>
  <div class="collapse" id="check${c.c_no}">
  
  <form action="AnnounceCommentModifyController">
  <div>
  <textarea class="form-control mt-2" id="CommentArea" rows="3" name="c_text" placeholder="댓글을 입력해주세요"></textarea>
  <input name="no" value="${p.p_no}" type="hidden" >
  <button class="btn btn-primary mt-2 btn-sm" name="c_no" value="${c.c_no}" > 수정하기  </button>
  </div>
  </form>
</div>

</c:when>
		
		
		<c:otherwise> <div> <span></span> </div> </c:otherwise>
		</c:choose>
		</div>
		</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
			<c:if test="${not empty sessionScope.accountInfo }">
			 <div>
			<label for="CommentArea" class="form-label">댓글</label>
			 <form action="AnnounceCommentController">
			 		<input name="c_user" value="${sessionScope.accountInfo.nickname} " type="hidden">
			 		<input name="no" value="${p.p_no}" type="hidden">
					<textarea class="form-control" id="CommentArea" rows="3" name="c_text" placeholder="댓글을 입력해주세요"></textarea>	
			<button class="btn btn-outline-secondary mt-3" name="c_post" value="${p.p_no}" >작성하기</button>
			 </form> 
			 
			</div>
			</c:if>
			
			
			
			 </td>
		</tr>
		<tr>
			<td colspan="4">  이전글 <a href="AnnounceDetailC?no=${prevP.p_no}"> ${prevP.p_title} </a></td>
		</tr>
		<tr>
			<td colspan="4">  다음글 <a href="AnnounceDetailC?no=${nextP.p_no}"> ${nextP.p_title} </a></td>
		</tr>
	</table>
<script type="text/javascript" src="js/announce.js"></script>
</body>
</html>