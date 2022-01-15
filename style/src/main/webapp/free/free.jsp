<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>

<style>

a{
	text-decoration: none;

}

a:hover {
	text-decoration: underline;
}

</style>
<body>
	
	
		<!-- <form action="SearchController">
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
		</form> -->
		<div class="m-3">
		<table class="table  table-striped table-hover" > 
	<thead class="table-dark">
	<tr>
				<th >종류</th>
				<th class="col-9">글제목</th>
				<th>작성자</th>
				<th >날짜</th>
			</tr>
	</thead>
			
			<tbody>
			<c:forEach var="p" items="${posts}">
				<tr>
					<td >자유글</td>
					<td class="col-9" > <a class="text-dark" href="FreeDetailC?no=${p.p_no}"> ${p.p_title} </a></td>
					<td >${p.p_user}</td>
					<td >${p.p_date}</td>
				</tr>
			</c:forEach>
			<c:if test="${not empty sessionScope.accountInfo }">
			<tr>
				<!-- <td colspan="4" style="text-align: right" onclick="location.href='FreeWriteController'">글쓰기</td> -->
				<td colspan="4" >
				<div class="d-flex col-2 float-end justify-content-end pe-4 "> <button class="btn btn-primary" onclick="location.href='FreeWriteController'">글쓰기</button> </div>
				</td>
				
			</tr>
			</c:if>
			
			<tr>
				<td colspan="4"> 
				<form action="FreeSearchController" accept-charset="UTF-8">
				<div class="d-flex col-12  justify-content-center">
				<div class="d-flex col-1" >
				<select class="form-select form-select-sm" name="selected">
						<option value="p_title">제목</option>
						<option value="p_text">내용</option>
						<option value="p_user">작성자</option>
				</select>
				</div>
					<input class="col-lg-10" name="searchText"> <button class="btn btn-success">검색</button>
				</div>
				</form>
				</td>
				
			</tr>
			</tbody>
		</table>
		
		<div>
				<ul class="pagination justify-content-center ">
				
			<!-- 검색어 없을 때 조건 -->
				<c:choose> <c:when test="${empty searchText}">
				<c:choose>
				<c:when test="${pageNum eq 1 || empty pageNum}"><li class="page-item disabled"> <a class="page-link"  href="FreeController?pageNum=${pageNum -1}&selected=${selected}&searchText=${searchText}">Previous</a> </li></c:when>
				<c:otherwise>
					<li class="page-item"> <a class="page-link"  href="FreeController?pageNum=${pageNum -1}&selected=${selected}&searchText=${searchText}">Previous</a> </li>
				</c:otherwise>
				</c:choose>
			<c:forEach var="p" items="${startEnd }">
					<li class="page-item"> <a class="page-link"  href="FreeController?pageNum=${p}&selected=${selected}&searchText=${searchText}">${p}</a> </li>
			</c:forEach>
			<c:choose>
				<c:when test="${pageNum eq totalPage }"><li class="page-item disabled"> <a class="page-link"  href="FreeController?pageNum=${pageNum}&selected=${selected}&searchText=${searchText}">Next</a> </li></c:when>
				<c:otherwise>
					<li class="page-item"> <a class="page-link"  href="FreeController?pageNum=${pageNum +1}&selected=${selected}&searchText=${searchText}">Next</a> </li>
				</c:otherwise>
				</c:choose>
			
			</c:when> 
			
			
			<c:otherwise>
			<c:choose>
				<c:when test="${pageNum eq 1}"><li class="page-item disabled"> <a class="page-link"  href="FreeSearchController?pageNum=${pageNum -1}&selected=${selected}&searchText=${searchText}">Previous</a> </li></c:when>
				<c:otherwise>
					<li class="page-item"> <a class="page-link"  href="FreeSearchController?pageNum=${pageNum -1}&selected=${selected}&searchText=${searchText}">Previous</a> </li>
				</c:otherwise>
				</c:choose>
			<c:forEach var="p" items="${startEnd }">
					<li class="page-item"> <a class="page-link"  href="FreeSearchController?pageNum=${p}&selected=${selected}&searchText=${searchText}">${p}</a> </li>
			</c:forEach>
			<c:choose>
				<c:when test="${pageNum eq totalPage }"><li class="page-item disabled"> <a class="page-link"  href="FreeSearchController?pageNum=${pageNum}&selected=${selected}&searchText=${searchText}">Next</a> </li></c:when>
				<c:otherwise>
					<li class="page-item"> <a class="page-link"  href="FreeSearchController?pageNum=${pageNum +1}&selected=${selected}&searchText=${searchText}">Next</a> </li>
				</c:otherwise>
				</c:choose>
			</c:otherwise>
			
			</c:choose>
				</ul>
		</div>
		</div>

	
</body>
</html>