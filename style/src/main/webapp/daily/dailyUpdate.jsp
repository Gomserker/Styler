<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container border border-dark mt-3">

		<form action="UpdateDaily" method="post" enctype="multipart/form-data"
			accept-charset="UTF-8">
			<div class="mt-2 row">
				<label for="username"
					class="col-2 col-form-label text-center  ms-3 ">User name</label>
				<div class="col-2">
					<input type="text" class="form-control text-center" id="username"
						placeholder="" name="user" readonly
						value="${sessionScope.accountInfo.nickname}"> <input
						name="view_count" value="0" type="hidden">
				</div>
			</div>

			<div class="mt-2">
				<label for="title" class="form-label"></label> <input type="text"
					class="form-control" id="title" placeholder="제목을 입력해 주세요"
					name="title" required value="${r.title}">
			</div>
			<div class="m-3">
				<small><span class="text-muted">※음란물, 차별, 비하, 혐오 및
						초상권, 저작권 침해 게시물은 민, 형사상의 책임을 질 수 있습니다.</span></small>
			</div>
			<div class=" ps-3 pe-3">


				<div class="mt-2 col-6">
					<div class="mb-3">
						<label for="postPic" class="form-label"> </label> <input
							class="form-control form-control-sm" type="file" id="postPic"
							name="image" required>
					</div>
				</div>

				<table>



					<tr>
						<td>상의</td>
						<td><input name="top" value="${r.top}"></td>
					</tr>
					<tr>
						<td>하의</td>
						<td><input name="pants" value="${r.top}"></td>
					</tr>
					<tr>
						<td>슈즈</td>
						<td><input name="shoes" value="${r.top}"></td>
					</tr>
					<tr>
						<td>악세서리</td>
						<td><input name="accessary" value="${r.top}"></td>
					</tr>

					<tr>
						<td>구매가격</td>
						<td><input name="price" value="${r.top}"></td>
					</tr>

					<tr>
						<td>타입</td>
						<td><input type="radio" name="type" value="빈티지">빈티지 <input
							type="radio" name="type" value="캐쥬얼">캐쥬얼</td>
					</tr>



					<tr>
						<td>색상</td>
						<td><input type="radio" name="color" value="black">black
							<input type="radio" name="color" value="white">white</td>
					</tr>


				</table>


				<div class="mb-3">
					<label for="Textarea" class="form-label">본문</label>
					<textarea class="form-control" id="Textarea" rows="10" name="text">${r.text}</textarea>
				</div>

				<div class="d-flex justify-content-end">
					<button name="no" class="btn btn-outline-success" value="${r.no}">글쓰기</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>