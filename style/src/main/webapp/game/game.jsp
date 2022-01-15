<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/game.css">
</head>
<body>

	<div id="g_span">카드 클릭시 출석체크 및 출석포인트 획득 가능!</div>
	<div id="g_form">
	<form 
		action="GameController?id=${sessionScope.accountInfo.id}&checkPoint=${sessionScope.accountInfo.checkPoint}&id=${sessionScope.accountInfo.id}"
		method="post"
		onsubmit="return call('${sessionScope.accountInfo.checkDate}');">


		
					<button class="card" name="pw" value="${sessionScope.accountInfo.pw}">
						<img alt="" src="css/img/게임카드.jpg" width="400px" height="500px">
					</button>
				
					<button class="card" name="pw" value="${sessionScope.accountInfo.pw}">
						<img alt="" src="css/img/게임카드.jpg" width="400px" height="500px">
					</button>
				
					<button class="card" name="pw" value="${sessionScope.accountInfo.pw}">
						<img alt="" src="css/img/게임카드.jpg" width="400px" height="500px">
					</button>
		

	</form>
	</div>
	<script type="text/javascript" src="js/game/game.js">

</script>
</body>
</html>