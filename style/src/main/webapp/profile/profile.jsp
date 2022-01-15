<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="ProfileController" method="post">
	<table border="1">
		<tr>
			<td colspan="2">
				<table border="1">
					<tr>
						<td rowspan="3">프사1</td>
					</tr>
					<tr>
						<td>아이디</td>
					</tr>
					<tr>
						<td>이메일</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>이름</td><td>닉네임</td>
		</tr>
		<tr>
			<td>성별</td><td>옷취향</td>
		</tr>
	</table>
	<button>수정하기</button>
	<button type="button" onclick="location.href='HomeController'">확인</button>
</form>

</body>
</html>