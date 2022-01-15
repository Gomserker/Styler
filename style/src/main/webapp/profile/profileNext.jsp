<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ProfileController?update=yes" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td colspan="2">
				<table border="1">
					<tr>
						<td rowspan="3">프로필사진 <input type="file"></td>
					</tr>
					<tr>
						<td>아이디</td>
					</tr>
					<tr>
						<td>이메일<input name="email"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>이름</td><td>닉네임 <input></td>
		</tr>
		<tr>
			<td>성별</td><td>옷취향<input></td>
		</tr>
	</table>
	<button>수정하기</button>
	
	</form>


</body>
</html>