<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
<title>Styler</title>


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
        <form class="needs-validation" action="FindID" name="form" method="post"  onsubmit="return call();" >
        
            
            
            <div class="mt-2">
              <label for="realName" class="form-label">이름</label>
              <input type="text" class="form-control" id="realName" placeholder="빈칸x 한글 공백x 30자미만" value="" name="name1" required>
            </div>


            
            <div class="mt-2">
              <label for="email" class="form-label">Email </label>
              <input type="email" class="form-control" id="email" placeholder="@포함, 빈칸x,영어숫자 공백x 50자미만" name="email" required>
            </div>


            

          <hr class="my-4">
		<div class="d-flex justify-content-center">
          <button class="w-50 btn btn-primary btn-lg " type="submit">FindID</button>
          </div>
        </form>
        </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2022 장식용</p>
    
  </footer>
</div>
	
	
	<script type="text/javascript" src="js/login/findID.js"></script>
	
	
	
</body>
</html>