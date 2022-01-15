<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
<title>Insert title here</title>




</head>

<body>

	
	
	<div class="container">
  <main>
    <div class="py-5 pb-0  d-flex justify-content-center">
    <form action="ProfileC" name="form" method="post"
					enctype="multipart/form-data" onsubmit="return call();">
      <img class="d-block mx-auto mb-4" src="img/${sessionScope.accountInfo.profileImg}" alt="" width="180" height="auto">
    <div class="input-group ">
  <input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload" name="img">
  <button class="btn btn-outline-secondary" type="submit" id="inputGroupFileAddon04" name="id" value="${sessionScope.accountInfo.id}" >사진 변경</button>
</div>
    
    </form>
    </div>

    <div class=" d-flex justify-content-center mt-2">
      	<div class="col-6">
        
            <div class="mt-2">
              <label for="id" class="form-label">아이디</label>
              <input type="text" class="form-control" id="id" placeholder=""  name="id" value="${sessionScope.accountInfo.id }" disabled>
            </div>
            
            <div class="mt-2">
              <label for="id" class="form-label">비밀번호</label>
              <input type="password" class="form-control" id="id" placeholder=""  name="pw" value="${sessionScope.accountInfo.pw }" disabled>
            </div>
            
            <div class="mt-2">
              <label for="realName" class="form-label">이름</label>
              <input type="text" class="form-control" id="realName" placeholder="" value="${sessionScope.accountInfo.name }" name="name1" disabled>
            </div>


            <div class="mt-2">
              <label for="username" class="form-label">닉네임</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="username" placeholder=""  name="nickname" value="${sessionScope.accountInfo.nickname }" disabled>
              </div>
            </div>

            <div class="mt-2">
              <label for="email" class="form-label">Email </label>
              <input type="email" class="form-control" id="email" placeholder="" name="email" value="${sessionScope.accountInfo.email }" disabled>
            </div>


            <div class="mt-2">
              <label for="style" class="form-label">옷취향</label>
              <input type="text" class="form-control" id="style" placeholder="" name="style" value="${sessionScope.accountInfo.style }" disabled>
              
            </div>
            
            <div class="mt-2">
              <label for="style" class="form-label">출석포인트</label>
              <input type="text" class="form-control" id="style" placeholder="" name="style" value="${sessionScope.accountInfo.checkPoint }" disabled>
              
            </div>

          <div class="mt-2">
              <label for="gender" class="form-label">성별</label>
              <input type="text" class="form-control" id="gender" placeholder="" name="gender" value="${sessionScope.accountInfo.gender }" disabled>
          </div>
          
          <div class="py-5 pb-0  d-flex justify-content-center">
						<form
							action="LevelUp?typeOfManger=${sessionScope.accountInfo.typeOfManger}&checkPoint=${sessionScope.accountInfo.checkPoint}&id=${sessionScope.accountInfo.id}"
							name="form">
							<div class="mt-2">
								<label for="gender" class="form-label" style="margin:0 auto;" >등급</label> <input
									type="text" class="form-control" id="gender" placeholder=""
									name="typeOfManger"
									value="${sessionScope.accountInfo.typeOfManger }" disabled >
							</div>
							<div class="input-group ">
								<button style="margin:10px auto;" type="button" class="btn btn-outline-secondary"
									 name="pw" onclick="location.href='LevelUp?typeOfManger=${sessionScope.accountInfo.typeOfManger}&checkPoint=${sessionScope.accountInfo.checkPoint}&id=${sessionScope.accountInfo.id}&pw=${sessionScope.accountInfo.pw}'"
									value="${sessionScope.accountInfo.pw}">등급업</button>
							</div>

						</form>
					</div>
    
    
    

          <hr class="my-4">
		<div class="d-flex justify-content-center">
          <button class="w-50 btn btn-outline-secondary btn-lg m-1 " type="button" onclick="location.href='UpdateAccountC'" >정보수정하기</button>
          <button class="w-50 btn btn-outline-danger btn-lg m-1 " type="button" onclick="delAccount('${sessionScope.accountInfo.id}')" >회원탈퇴</button>
          </div>   
        </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2022 장식용</p>
    
  </footer>
</div>			
				
				
	
<script type="text/javascript" src="js/login/profileChange.js"></script>
<script type="text/javascript" src="js/login/SignOut.js"></script>

</body>
</html>