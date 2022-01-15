<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
<title>Insert title here</title>


<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    
      <!-- Custom styles for this template -->
    <link href="css/form-validation.css" rel="stylesheet">
    
</head>
<body class="bg-light">
	 
	
	<div class="container">
  <main>
    <div class="py-5 pb-0 text-center ">
      <img class="d-block mx-auto mb-4" src="css/img/stylerlogo.png" alt="" width="180" height="auto">
    </div>

    <div class=" d-flex justify-content-center mt-2">
      	<div class="col-6">
        <form class="needs-validation" action="SignUpC" name="form" method="post" enctype="multipart/form-data" onsubmit="return call();" >
        
            <div class="mt-2">
              <label for="id" class="form-label">아이디</label>
              <input type="text" class="form-control" id="id" placeholder="빈칸x 영어+숫자 공백x 8이상~20자미만"  name="id" required >
            </div>
            
            <div class="mt-2">
              <label for="password" class="form-label">비밀번호</label>
              <input type="password" class="form-control" id="password" placeholder="빈칸x 영어+숫자+특수문자 + 공백x 8자이상" name="pw" required>
              
            </div>
            <div class="mt-2">
              <label for="passwordCheck" class="form-label">비밀번호확인</label>
              <input type="password" class="form-control" id="passwordCheck" placeholder="" name="pwCheck" required>
            </div>
            
            <div class="mt-2">
              <label for="realName" class="form-label">이름</label>
              <input type="text" class="form-control" id="realName" placeholder="빈칸x 한글 공백x 30자미만" value="" name="name1" required>
            </div>


            <div class="mt-2">
              <label for="username" class="form-label">닉네임</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="username" placeholder="빈칸x 한글+영어+숫자 공백x 10자~20자"  name="nickname" required>
              </div>
            </div>

            <div class="mt-2">
              <label for="email" class="form-label">Email </label>
              <input type="email" class="form-control" id="email" placeholder="@포함, 빈칸x,영어숫자 공백x 50자미만" name="email" required>
            </div>


            <div class="mt-2">
              <label for="style" class="form-label">옷취향</label>
              <select class="form-select" id="style"  name="style" required>
                <option value="" selected disabled hidden >Choose...</option>
                	<option value="casual">캐쥬얼</option>
					<option value="Street">스트리트</option>
					<option value="vintage">빈티지</option>
					<option value="dandy">댄디</option>
              </select>
            </div>

            <div class="mt-2">
              <div class="mb-3">
 				 <label for="profilePic" class="form-label">프로필 사진 <span class="text-muted">jpg, png only</span> </label>
 					 <input class="form-control form-control-sm" type="file" id="profilePic" name="profileImg" required >
				</div>
            </div>
            
            <h6 class="mb-3">성별</h6>

          <div class="my-3">
            <div class="form-chec form-check-inline">
              <input id="man" name="gender"  value="man" type="radio" class="form-check-input" checked required>
              <label class="form-check-label" for="man">남</label>
              <input id="woman" name="gender"  value="woman" type="radio" class="form-check-input" required>
              <label class="form-check-label" for="woman">여</label>
            </div>
          </div>

            

          <hr class="my-4">

          <div class="form-check">
            <input type="checkbox" class="form-check-input" id="right1" name="typeOfManager" value="0" >
            <label class="form-check-label" for="right1">개인정보 이용에 동의 합니다.</label>
          </div>

          <div class="form-check">
            <input type="checkbox" class="form-check-input" id="right12" name="checkPoint" value="1" >
            <label class="form-check-label" for="right2" >개인정보 수집에 동의 합니다.</label>
          </div>

          <hr class="my-4">
		<div class="d-flex justify-content-center">
          <button class="w-50 btn btn-primary btn-lg " type="submit">Sign up</button>
          </div>
        </form>
        </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2022 장식용</p>
    
  </footer>
</div>
	
	
	<script type="text/javascript" src="js/login/signUp.js"></script>
	
	
	
</body>
</html>