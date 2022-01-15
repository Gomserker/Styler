<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
body {
	display: flex;
	flex-direction: column;
}

.btn-outline-red {
	background-color: #f9e000;
	color: #4b4737;
	font-weight: 700;
}

.btn-outline-red:hover {
	background-color: red;
	color: white;
	font-weight: 700;
}

.scrollBox {
	position: fixed;
	width: 50px;
	z-index: 999999999;
	left: 3%;
}

.button {
	font-size: 50px;
	font-weight: 700;
	text-decoration: none;
	color: black;
}

.button:hover {
	color: red;
}
</style>
</head>
<body>

	<%-- <form action="SearchController">
		<div class="menu">
			<input type="checkbox" class="" id="collapsible"> <label
				for="collapsible"><span>검색 - 누르면 밑에 검색창 </span></label>
			<ul id="menuitems" class="menuitems">
				<li><input name="searchMain"></li>

				<li><select name="postMain">
						<option>리뷰</option>
						<option>데일리</option>
				</select></li>
				<li><select name="colorMain">
						<option>red</option>
						<option>black</option>
						<option>white</option>
				</select></li>
				<li><button>검색하기</button></li>

			</ul>
		</div>
	</form>
	<table border="1">

		<tr>
			<td onclick="location.href='HomeController'">타이틀</td>

			<td onclick="location.href='ProfileController'">내정보</td>
			<!-- <td onclick="location.href='WritePost'">리뷰쓰기</td> -->
			<c:if test="${not empty sessionScope.accountInfo }">
				<td onclick="location.href='WritePost'">리뷰쓰기</td>
			</c:if>
		</tr>

		

		<tr>
			<td colspan="4">
				<table border="1">
					<tr>
						<td>인기순</td>
						<td>최신글</td>
						<td>댓글순</td>
					</tr>
				</table>
			</td>
		</tr>

		

		<tr>
			<td colspan="4"><c:forEach var="r" items="${reviews}">
					<table border="1">
						<tr>
							<td><img src="img/${r.img}" alt="이미지 없음"
								onclick="location.href='ReadDetailC?no=${r.no}'"></td>
							<td>${r.user}</td>
						</tr>
						<tr>
							<td>${r.text}</td>
						</tr>
						<tr>
							<td>${r.good}</td>
							<td>${r.comment}</td>
						</tr>
					</table>
				</c:forEach></td>
		</tr>
	</table> --%>
	
	
	
	 <!-- 홈.jsp -->
	 <div  class="container-fluid  row mt-5"  >
            <div  class="d-flex align-items-center justify-content-center" >
                <a  href="RevViewSearch" class="btn btn-outline-dark border-white rounded-pill">
            인기
          </a>
          <a  href="RevDateSearch" class="btn btn-outline-dark border-white rounded-pill">
            최신
          </a>
          <a  href="RevRandomSearch" class="btn btn-outline-dark border-white rounded-pill">
            랜덤
          </a>
          
           <a href="WritePost"
				class="btn btn-outline-red border-white rounded-pill">리뷰 작성</a>
          
        </div>
        </div>
	
	
	
	
	
	<div class="album py-5 bg-WHITE">
		<div class="container">

			<div
				class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-3">

				<c:forEach var="r" items="${reviews}">
					<div class="col">
						<div class="card shadow-sm">

							<a
								href="ReadDetailC?no=${r.no}&mynick=${sessionScope.accountInfo.nickname}">
								<img alt="게시글 이미지" src="img/${r.img}" class="card-img-top "
								width="auto" height="225">
							</a>

							<div class="card-body">
								<p class="card-text">${r.text}</p>
								<div
									class="d-flex justify-content-between align-items-center flex-wrap">
									<div class="btn-group">

										<!--  좋아요개수표시 -->
										<c:set var="NumOfLike" value="0" />
										<c:forEach var="countLike" items="${alcs}">
											<c:if test="${ r.no eq countLike.postNo }">
												<c:set var="NumOfLike" value="${countLike.numberOfLike}" />
											</c:if>
										</c:forEach>
										<button type="button" class="btn btn-sm btn-outline-secondary"
											onclick="location.href='ReadDetailC?no=${r.no}&mynick=${sessionScope.accountInfo.nickname}'">
											<img class="me-2" alt="liked" src="img/heart-fill.svg">
											${NumOfLike}
										</button>

										<!--  댓글개수표시 -->
										<c:set var="NumOfComment" value="0" />
										<c:forEach var="countComment" items="${accs}">
											<c:if test="${ r.no eq countComment.postNo }">
												<c:set var="NumOfComment"
													value="${countComment.numberOfComment}" />
											</c:if>
										</c:forEach>
										<button type="button" class="btn btn-sm btn-outline-secondary"
											onclick="location.href='ReadDetailC?no=${r.no}&mynick=${sessionScope.accountInfo.nickname}#comment'">댓글
											${NumOfComment}</button>
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
				<div class="scrollBox">
					<div class="scroll">
						<a href="#head" class="button">^</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/Review.js"></script>
	<script type="text/javascript" src="js/reviewlike.js"></script>
</body>
</html>