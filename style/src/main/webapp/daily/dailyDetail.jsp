<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="css/reviewDetail.css" /> -->
<style>
a {
text-decoration: none;
color: black;
}
</style>
</head>
<body>
	<%-- <div class="content-header">
		<div class="content-header_view">
			<div class="content-header_view_left">
				
				<div class="content-header_view_left_text">
					<h2>${r.title}</h2>
					<!-- member nickname -->
					<span>${r.user}</span>
				</div>
			</div>
			<div class="content-header_view_right">
				<div class="content-header_view_right_1st">
					<ul class="post-menu">
						<li><a onclick="pressLike()" class="like"><i
								class="fas fa-heart fa-1x"></i></a></li>
						<li><a onclick="location.href='UpdatePost?no=${r.no}'">수정하기</a></li>
						<li><a onclick="deleteReview(${r.no})">삭제하기</a></li>
					</ul>
				</div>
				<div class="content-header_view_right_2nd">
					<span>조회수 : ${r.view_count}</span><br /> <span>작성일 : ${r.date}</span>
				</div>

			</div>
		</div>
	</div>
	--%>


	<%-- <div class="content-body_img">
		<img src="img/${r.img}" alt="이미지 없음" />
	</div> --%>


	<%-- <div class="content-body_text">
			<span>${r.text}</span>
		</div>
		<c:forEach var="c" items="${comments}">
		<table>
			<tr>
				<td>${c.c_users} || <fmt:formatDate value="${c.c_date}" pattern="yyyy.MM.dd a hh:mm"/> || 수정 || 삭제</td>
			</tr>
			<tr>
				<td>${c.c_text}</td>
			</tr>
		</table>
		</c:forEach>
		<form action="ReviewCommentC">
		<table>
			<tr>
				<td>
					<button name="post" value="${r.no}">comment submit</button> 
				</td>
			</tr>
			<tr>
				<td>
					
					<input name="user" value="${sessionScope.accountInfo.nickname}" type="hidden">
					<input name="no" value="${r.no}" type="hidden">
					<textarea placeholder="input text here" name="text"></textarea>
				</td>
			</tr>
		</table>
		</form>
	</div> --%>
	<table class="table table-borderless" style="width: 95%; margin: auto"
		border="2">
		<tr>
			<td class="h5 ps-3 border-bottom" colspan="4">${r.title}</td>
		</tr>

		<tr>
			<td class="ps-3" colspan="2" style="text-align: auto"><small>
					${r.user} </small> | <small class="text-muted"> <fmt:formatDate
						value="${r.date}" pattern="yyyy.MM.dd / a hh:mm" />
			</small></td>
			<td colspan="2" style="text-align: center"><small>조회수
					${r.view_count}</small> <small>|</small> <small>댓글수 ${totalComment}</small>
					<small>|</small> <small> 좋아요 ${totalLike }</small>
					 <c:choose>
                    <c:when test="${likecheck eq 'alreadyliked'}">
                     <button class="btn btn-outline-secondary btn-sm" onclick="location.href='DailyDeleteLikeController?no=${r.no}&mynick=${sessionScope.accountInfo.nickname}'"><img alt="liked" src="img/heart-fill.svg"> LIKED</button>
                     </c:when>
                     <c:otherwise >
                     <button class="btn btn-outline-secondary btn-sm" onclick="return needLogin('${r.no}','${sessionScope.accountInfo.nickname}');"> <img alt="like" src="img/heart.svg"> LIKE</button>
<%--                      <button onclick="location.href='AddLikeController?no=${r.no}&mynick=${sessionScope.accountInfo.nickname}'">좋아요</button> --%>
                      </c:otherwise>
                     </c:choose>
			</td>
		</tr>
			
			<tr>
				<th>상의</th>
				<td><a href="https://search.shopping.naver.com/search/all?query=${r.top}&cat_id=&frm=NVSHATC" target="_blank">${r.top}</a></td>
			</tr>
			<tr>
				<th>하의</th>
				<td><a href="https://search.shopping.naver.com/search/all?query=${r.pants}&cat_id=&frm=NVSHATC" target="_blank">${r.pants}</a></td>
			</tr>
			<tr>
				<th>신발</th>
				<td><a href="https://search.shopping.naver.com/search/all?query=${r.shoes}&cat_id=&frm=NVSHATC" target="_blank">${r.shoes}</a></td>
			</tr>
			<tr>
				<th>악세서리</th>
				<td><a href="https://search.shopping.naver.com/search/all?query=${r.accessary}&cat_id=&frm=NVSHATC" target="_blank">${r.accessary}</a></td>
			</tr>
			<tr>
				<th>가격</th>
				<td>￦${r.price}</td>
			</tr>
			
		<tr>
		
			<td class="ps-3 border" colspan="4"><img src="img/${r.img}">
				<br>${r.text}</td>

		</tr>

		<c:set var="writerName" value="${r.user}" />
		<c:set var="loginName" value="${sessionScope.accountInfo.nickname}" />


		<c:if test="${fn:trim(r.user) eq loginName || loginName eq 'admin'}">
			<tr>
				<td colspan="3"></td>
				<td style="text-align: center">
					<button class="btn btn-secondary"
						onclick="location.href='UpdateDaily?no=${r.no}'">수정</button>
					<button class="btn btn-secondary"
						onclick="location.href='DailyController'">목록으로</button>
					<button class="btn btn-danger" onclick="deleteDaily(${r.no})">삭제</button>
				</td>
			</tr>

		</c:if>
		
		<!-- 관리자 수정삭제 -->
<c:if
			test="${sessionScope.accountInfo.typeOfManger eq '플레티넘' || sessionScope.accountInfo.typeOfManger eq '다이아'}">
			<tr>
				<td colspan="4"><hr class=""></td>
			</tr>

			<tr>
				<td colspan="3"></td>
				<td style="text-align: center">
					<button class="btn btn-secondary"
						onclick="location.href='UpdateDaily?no=${r.no}'">수정-관리자</button>
					<button class="btn btn-danger" onclick="deleteDaily(${r.no})">삭제-관리자</button>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="4"><hr class=""></td>
		</tr>

		<c:forEach var="c" items="${comments}">
			<tr>
				<td>

					<div class="border-bottom">
						<div>
							<small> ${c.c_users} </small>
						</div>
						<div>${c.c_text}</div>
						<div>
							<small class="text-muted"><fmt:formatDate
									value="${c.c_date}" pattern="yyyy.MM.dd/ a hh:mm" /></small>
						</div>

						<c:set var="Cuser" value="${c.c_users }"></c:set>
						<c:choose>
							<c:when
								test="${fn:trim(Cuser) eq sessionScope.accountInfo.nickname}">
								<div class="btn-group  btn-group-sm mt-2">
									<button class="btn btn-outline-secondary"
										data-bs-toggle="collapse" data-bs-target="#check${c.c_no}"
										aria-expanded="false" aria-controls="수정">수정</button>
									<button class="btn btn-outline-danger"
										onclick="dailyCommentDelCheck(${c.c_no},${r.no})">삭제</button>
								</div>
								<div class="collapse" id="check${c.c_no}">

									<form action="DailyCommentUpdateC">
										<div>
											<textarea class="form-control mt-2" id="CommentArea" rows="3"
												name="c_text" placeholder="댓글을 입력해주세요"></textarea>
											<input name="no" value="${r.no}" type="hidden">
											<button class="btn btn-primary mt-2 btn-sm" name="c_no"
												value="${c.c_no}">수정하기</button>
										</div>
									</form>
								</div>

							</c:when>


							<c:otherwise>
								<div>
									<span></span>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><c:if
					test="${not empty sessionScope.accountInfo }">
					<div>
						<label for="CommentArea" class="form-label">댓글</label>
						<form action="DailyCommentC">
							<input name="user" value="${sessionScope.accountInfo.nickname} "
								type="hidden"> <input name="no" value="${r.no}"
								type="hidden">
							<textarea class="form-control" id="CommentArea" rows="3"
								name="text" placeholder="댓글을 입력해주세요"></textarea>
							<button class="btn btn-outline-secondary mt-3" name="post"
								value="${r.no}">작성하기</button>
						</form>

					</div>
				</c:if></td>
		</tr>

	</table>


	<script src="https://kit.fontawesome.com/69688adaa8.js"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/daily.js"></script>
	<script type="text/javascript" src="js/dailyLike.js"></script>
</body>
</html>