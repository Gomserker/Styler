<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="generator" content="Hugo 0.88.1">
<title>Signin</title>


<link rel="icon" type="image/png"
	href="http://wiki.hash.kr/images/thumb/8/82/%EC%95%84%EC%9D%B4%EC%BD%98_%EB%A1%9C%EA%B3%A0.png/200px-%EC%95%84%EC%9D%B4%EC%BD%98_%EB%A1%9C%EA%B3%A0.png">
<!-- BootStrap -->

<link rel="stylesheet" href="css/bootstrap.css">
<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center">


	<main class="form-signin">
		<form action="LoginController" method="post" name="form"
			onsubmit="return call();">
			<a href="HomeController"> <img class="mb-3"
				src="css/img/stylerlogo.png" alt="" width="180" height="auto">
			</a>
			<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

			<div class="form-floating">
				<input type="text" class="form-control" id="floatingInput"
					placeholder="ID" name="id"> <label for="floatingInput">ID</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword"
					placeholder="Password" name="pw"> <label
					for="floatingPassword">Password</label>
			</div>

			<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
				in</button>
		</form>
		<div class="d-flex  justify-content-between px-3">
			<a href="#">Find ID</a> <a href="#">Find Password</a> <a
				href="SignUpC">Sign up</a>
		</div>

	</main>

	<script type="text/javascript" src="js/login/signInNext.js"></script>

</body>
</html>