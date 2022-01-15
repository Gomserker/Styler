<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	
	 <!-- 홈.jsp -->
	 <div  class="container-fluid  row mt-5"  >
            <div  class="d-flex align-items-center justify-content-center" >
                <a  href="ViewSearch" class="btn btn-outline-dark border-white rounded-pill">
            인기
          </a>
          <a  href="HomeController" class="btn btn-outline-dark border-white rounded-pill">
            최신
          </a>
          <a  href="RandomSearch" class="btn btn-outline-dark border-white rounded-pill">
            랜덤
          </a>
          
        </div>
        </div>
	 
	 <!-- 리뷰페이지 컨텐츠 -->
         <div class="album py-5 bg-WHITE">
      <div class="container">
  		<h3 class="mb-3 text-secondary fw-bold"> Review </h3>
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-3">
         
          <c:forEach var="r" items="${reviews}" >
          <div class="col">
            <div class="card shadow-sm">
              
            <a href="ReadDetailC?no=${r.no}&mynick=${sessionScope.accountInfo.nickname}"> <img alt="게시글 이미지" src="img/${r.img}" class="card-img-top " width="auto" height="225"> </a>
  
              <div class="card-body">
                <p class="card-text">${r.text}</p>
                <div class="d-flex justify-content-between align-items-center flex-wrap">
                  <div class="btn-group">
                   
                   <!--  좋아요개수표시 -->
                     <c:set var="NumOfLike" value="0"/>   
                     <c:forEach var="countLike" items="${alcs}" >
                    <c:if test="${ r.no eq countLike.postNo }">
                      <c:set var="NumOfLike" value="${countLike.numberOfLike}"/> 
                     </c:if>
                     </c:forEach>
                    <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='ReadDetailC?no=${r.no}&mynick=${sessionScope.accountInfo.nickname}'" ><img class="me-2" alt="liked" src="img/heart-fill.svg"> ${NumOfLike}</button>
                    
                   <!--  댓글개수표시 -->
                     <c:set var="NumOfComment" value="0"/>   
                     <c:forEach var="countComment" items="${accs}" >
                    <c:if test="${ r.no eq countComment.postNo }">
                      <c:set var="NumOfComment" value="${countComment.numberOfComment}"/> 
                     </c:if>
                     </c:forEach>
                     <button type="button" class="btn btn-sm btn-outline-secondary"  onclick="location.href='ReadDetailC?no=${r.no}&mynick=${sessionScope.accountInfo.nickname}#comment'" >댓글 ${NumOfComment} </button> 
                  </div>
                  
                  <small class="text-muted"> <fmt:formatDate
											value="${r.date}" pattern="yy.MM.dd" /></small>
                  <!-- 유저등록사진표시 -->
                 <c:forEach var="p" items="${userP}"> 
                 <c:if test="${r.user eq p.nickname }">
                  <div class="col-12 flex-shrink-1 mt-2 ">
                 <img src="img/${p.u_img}"  alt="작성자프로필사진" width="32" height="32" class="rounded-circle ">
                 <small> ${r.user}</small>
                </div>
                  </c:if>
                   </c:forEach>
                </div>
              </div>
            </div>
          </div>
				</c:forEach>
				
				</div>
				</div>
				</div>
	
				
				
  
          
</body>
</html>