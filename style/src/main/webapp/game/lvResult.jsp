<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/lvResult.css">
</head>
<body>
	<div id="bg">
	<div id="result">당신의 등급은 [${sessionScope.accountInfo.typeOfManger}]입니다.</div>
	<br>
	<div class="back">
		<a id="home" href='HomeController'>홈으로</a><a href='InfoController'>내정보</a>
	</div>
	</div>
	
	
</body>
</html>