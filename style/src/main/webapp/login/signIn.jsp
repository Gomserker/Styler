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
    
    
    <!-- BootStrap -->

<link rel="stylesheet" href="css/bootstrap.css">
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
</head>
<body class="text-center">
	<!-- <table border="1">
		<tr>
			<td colspan="3" onclick="location.href='LoginController?signIn=yes'">로그인</td>
		</tr>
		<tr>
			<td>아이디찾기-미구현</td>
			<td>비밀번호찾기-미구현</td>
			<td onclick="location.href='SignUp'">회원가입</td>
		</tr>
	</table> -->
	
	<main class="form-signin">
  <form >
    <img class="mb-3" src="stylerlogo.png" alt="" width="180" height="auto">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="ID">
      <label for="floatingInput">ID</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
      <label for="floatingPassword">Password</label>
    </div>

    <!-- <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label> -->
    <!-- </div> -->
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
    <!-- <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p> -->
  </form>
  <div class="d-flex border border-3 justify-content-between px-3">
      <a href="" >Find ID</a>
      <a href="">Find Password</a>
      <a href="">Sign up</a>
  </div>
  
</main>
</body>
</html>