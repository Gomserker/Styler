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
    <div class="py-5 pb-0  justify-content-center text-center">
    
    <h5>회원정보수정</h5>
      <img class="d-block mx-auto mb-4" src="img/${sessionScope.accountInfo.profileImg}" alt="" width="180" height="auto">
    
    </div>

<form action="UpdateAccountC" onsubmit="return call();" name="form"	method="post" enctype="multipart/form-data" >

    <div class=" d-flex justify-content-center mt-2">
      	<div class="col-6">
        
            <div class="mt-2">
              <label for="id" class="form-label">아이디</label>
              <input type="text" class="form-control" id="id" placeholder=""  name="id" value="${sessionScope.accountInfo.id }" readonly>
            </div>
            
            <div class="mt-2">
              <label for="pw" class="form-label">비밀번호</label>
              <input type="password" class="form-control" id="pw" placeholder=""  name="pw" value="${sessionScope.accountInfo.pw }" >
            </div>
            
            <div class="mt-2">
              <label for="realName" class="form-label">이름</label>
              <input type="text" class="form-control" id="realName" placeholder="" value="${sessionScope.accountInfo.name }" name="name1" disabled>
            </div>


            <div class="mt-2">
              <label for="username" class="form-label">닉네임</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="username" placeholder=""  name="nickname" value="${sessionScope.accountInfo.nickname }">
              </div>
            </div>

            <div class="mt-2">
              <label for="email" class="form-label">Email </label>
              <input type="email" class="form-control" id="email" placeholder="" name="email" value="${sessionScope.accountInfo.email }" >
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
              <label for="gender" class="form-label">성별</label>
              <input type="text" class="form-control" id="gender" placeholder="" name="gender" value="${sessionScope.accountInfo.gender }" disabled>
          </div>

          <hr class="my-4">
		<div class="d-flex justify-content-center">
          <button class="w-50 btn btn-outline-secondary btn-lg m-1 " type="submit" >수정하기</button>
          </div>
        </div>
    </div>
    </form>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2022 장식용</p>
    
  </footer>
</div> 

	<script type="text/javascript" src="js/login/udateInfo.js"></script>
</body>
</html>