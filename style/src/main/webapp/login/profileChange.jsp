<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">

		<tr>
			<td>
				<form action="ProfileC" name="form" method="post"
					enctype="multipart/form-data" onsubmit="return call();">
					<table>
						<tr>
							<td><img src="img/${sessionScope.accountInfo.profileImg}" /></td>
						</tr>
						<tr>
							<td>사진선택:<input type="file" name="img">
							<button name="id" value="${sessionScope.accountInfo.id}">프로필
									사진변경하기</button></td>

						</tr>
					</table>
				</form>
			</td>
		</tr>

		<tr>
			<td colspan="2">- 로그인 정보</td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td>${sessionScope.accountInfo.nickname }</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${sessionScope.accountInfo.id }</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${sessionScope.accountInfo.pw }</td>
		</tr>
		<tr>
			<td colspan="2">- 개인정보</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${sessionScope.accountInfo.name }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${sessionScope.accountInfo.gender }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${sessionScope.accountInfo.email }</td>
		</tr>
		<tr>
			<td>옷취향</td>
			<td>${sessionScope.accountInfo.style }</td>
		</tr>
	</table>
	<button onclick="location.href='UpdateAccountC'">정보수정하기</button>
	<button onclick="location.href='SignOutC'">회원탈퇴</button>


	<script type="text/javascript" src="js/login/profileChange.js"></script>

</body>
</html>