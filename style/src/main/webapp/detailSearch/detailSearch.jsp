<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
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
	
	#blank_height {
		height: 100px;
	}
	
	.ds_categori{
	text-align: center;
	}
	
	
}
</style>

<!-- Custom styles for this template -->
<link href="css/form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">
	<div id="blank_height"></div>
	<div class="container">
		<main>


			<div class=" d-flex justify-content-center mt-2">
				<div class="col-6">
					<form class="needs-validation" method="post"
						action="DetailSearchController" name="form"
						onsubmit="return call();">

						<h6 class="ds_categori">카테고리</h6>

						<div class="my-3">
							<div class="form-chec form-check-inline">
								<input id="man" name="type" value="p_top" type="radio"
									class="form-check-input" checked required> <label
									class="form-check-label" for="man">상의</label> <br>
								<br> <input id="woman" name="type" value="p_pants"
									type="radio" class="form-check-input" required> <label
									class="form-check-label" for="woman">하의</label> <br>
								<br> <input id="woman" name="type" value="p_accessary"
									type="radio" class="form-check-input" required> <label
									class="form-check-label" for="woman">악세서리</label> <br>
								<br> <input id="woman" name="type" value="p_shoes"
									type="radio" class="form-check-input" required> <label
									class="form-check-label" for="woman">신발</label>
							</div>
						</div>
						
						<hr class="my-4">
						<div class="mt-2">
							<label for="id" class="form-label">키워드</label> <input type="text"
								class="form-control" id="id"
								placeholder="keyward" name="title" required>
						</div>

						<div class="mt-2">
							<label for="password" class="form-label">가격</label> <input
								type="text" class="form-control" id="password"
								 name="price" required>

						</div>











						<hr class="my-4">
						<div class="d-flex justify-content-center">
							<button class="w-50 btn btn-primary btn-lg " type="submit">가격으로
								조회</button>
						</div>
					</form>
				</div>
			</div>
		</main>

		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; 2022 styler</p>

		</footer>

		<div class="py-5 pb-0 text-center ">
			<img class="d-block mx-auto mb-4" src="css/img/stylerlogo.png" alt=""
				width="180" height="auto">
		</div>
	</div>



</body>
</html>