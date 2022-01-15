<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Styler</title>
<!-- 부트스트랩  -->
<!-- jquery -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<!-- BootStrap -->

<link rel="stylesheet" href="css/bootstrap.css">


<!-- 합쳐지고 최소화된 최신 자바스크립트 -->

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<!-- 기본스타일 설정  -->
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

<!-- 부트스트랩과 충돌로 주석처리  -->

<!-- Custom styles for this template -->
<!-- <link rel="stylesheet" href="css/style.css"> -->
<!-- <link rel="stylesheet" href="css/slider.css"> -->
<!-- <link rel="stylesheet" href="css/reviewDetail.css">
<link rel="stylesheet" href="css/top.css"> -->


<link rel="stylesheet" href="css/headers.css">
<link rel="icon" type="image/png"
	href="http://wiki.hash.kr/images/thumb/8/82/%EC%95%84%EC%9D%B4%EC%BD%98_%EB%A1%9C%EA%B3%A0.png/200px-%EC%95%84%EC%9D%B4%EC%BD%98_%EB%A1%9C%EA%B3%A0.png">
</head>

<body>
	<main>
		<div class="b-example-divider"></div>

		<nav class="navbar navbar-dark bg-dark">

			<div
				class="container-fluid d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

				<div class="col-12 col-lg-12 mb-3 ps-3 pt-3">
					<a class="navbar-brand ml-lg-5" href="HomeController"> <img
						src="css/img/stylerlogo.png" alt="logo" width="200px"
						height="85px">
					</a>


				</div>
				<div class="ps-3 mb-3  ">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
						aria-controls="offcanvasNavbar">
						<span class="navbar-toggler-icon"></span>
					</button>
				</div>
				<div class="col-11 col-lg-5 mb-3   ">
					<span class="d-none"> 검색바 길이조절</span>
				</div>
				<form class="col-12 col-lg-4 mb-3 mb-3 me-lg-3   flex-fill"
					action="MainSearch">
					<input type="search" name="title" class="form-control form-control-dark"
						placeholder="Search..." aria-label="Search">
				</form>

				<div class="mb-3 ">
					<jsp:include page="${loginPage}"></jsp:include>
				</div>


				<div class="offcanvas offcanvas-start bg-dark tabindex=-1"
					id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
					<div class="offcanvas-header">
						<h5 class="offcanvas-title text-white" id="offcanvasNavbarLabel">Menus</h5>
						<button type="button" class=" btn-close btn-close-white "
							data-bs-dismiss="offcanvas" aria-label="Close"></button>
					</div>
					<div class="offcanvas-body">
						<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="HomeController">홈으로</a></li>
							<li class="nav-item"><a class="nav-link"
								href="AnnounceController">공지사항</a></li>
							<li class="nav-item"><a class="nav-link"
								href="ReviewController">리뷰</a></li>
							<li class="nav-item"><a class="nav-link"
								href="DailyController">데일리</a></li>
							<li class="nav-item"><a class="nav-link"
								href="FreeController">자유게시판</a></li>
							<li class="nav-item"><a class="nav-link"
								href="QnaController">문의게시판</a></li>
							<li class="nav-item"><a class="nav-link"
								href="GameStartController">게임</a></li>
							<li class="nav-item"><a class="nav-link"
								href="DetailSearchController">가격으로 검색</a></li>


						</ul>
						<form class="d-flex mt-4" action="MainSearch">
							<input name="title" class="form-control me-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form>
					</div>
				</div>
			</div>
		</nav>

		<div class="b-example-divider"></div>



		<div>
			<jsp:include page="${contentPage}"></jsp:include>
		</div>

		<div class="b-example-divider"></div>

	</main>


	<!-- 기존내용 -->

	<%-- <table id="tbl" border="1">
		<tr>

			<td colspan="3"><jsp:include page="${loginPage}"></jsp:include>
				<jsp:include page="${contentPage}"></jsp:include></td>
		</tr>
		<tr>
			<td onclick="location.href='HomeController'">로고</td>
			<td>
				<section id="slider1" class="slider">
					<div class="box" style="background-color: #000;">Styler</div>
					<div class="box" style="background-color: #000;">Your Style</div>
					<div class="box" style="background-color: #000;">Styler</div>
					<div class="box" style="background-color: #000;">Your Style</div>
					<div class="box" style="background-color: #000;">Styler</div>
				</section>

				<section id="slider2" class="slider">
					<div class="box" style="background-color: #ff0000;">Styler</div>
					<div class="box" style="background-color: #ff0000;">Styler</div>
					<div class="box" style="background-color: #ff0000;">Styler</div>
					<div class="box" style="background-color: #ff0000;">Styler</div>
					<div class="box" style="background-color: #ff0000;">Styler</div>
				</section>
			</td>
			<td>footer</td>
		</tr>
	</table> --%>


	<!-- 부트스트랩과 충돌로 주석처리  -->
	<!-- <script type="text/javascript" src="js/slider.js"></script> -->
	<script type="text/javascript" src="js/freeboard.js"></script>
</body>
</html>