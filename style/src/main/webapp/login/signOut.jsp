<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<form action="SignOutC" method="post">
		<table border="1">
			<tr>
				<td> 잠깐!!<br> 정말 탈퇴하시려구요?</td>
			</tr>
			<tr>
				<td> 탈퇴 시 작성했던 모든 게시글과 댓글이 삭제되며<br> 
재가입 시에도 복구되지 않습니다.</td>
			</tr>
			<tr>
				<td>탈퇴 사유</td>
			</tr>
			<tr>
				<td>
					<textarea placeholder="탈퇴하시는 사유를 간단히 알려주시면 앞으로 개선하는데큰 도움이 됩니다.(50자 이내)">
					</textarea>
				</td>
			</tr>
			<tr>
				<td> <button name="id" value="${sessionScope.accountInfo.id}">탈퇴하기</button> </td>
			</tr>
		</table>
	</form>
</body>
</html>