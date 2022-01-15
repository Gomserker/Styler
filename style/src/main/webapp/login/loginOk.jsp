<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<title>Insert title here</title>
</head>
<body>
		<div class="border mt-4">
		<%-- <span> ${r } 로그인!! <br> 환영합니다 </span> <br>
		<button type="button" class="btn btn-outline-light me-2" onclick="location.href='LoginController'">MyInfo</button>
                <button type="button" class="btn btn-warning" onclick="location.href='SignUpC'">Logout</button>
			</div>	 --%>
		<span class="text-white"> ${sessionScope.accountInfo.nickname} 로그인!! <br> 환영합니다 </span> <br>
		<div class="dropdown">
                    <a href="#" class="d-block link-light text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                     <!--  유저프사 가져오기 -->
                      <img src="img/${sessionScope.accountInfo.profileImg}" alt="유저프로필사진" width="40" height="40" class="rounded-circle">
                    </a>
                    <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
                      <li><a class="dropdown-item" href="InfoController">Profile</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="LoginController">Sign out</a></li>
                    </ul>
                  </div>
				

</body>
</html>