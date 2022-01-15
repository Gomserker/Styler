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

		<form action="QnaModifyController" method="post"
			enctype="multipart/form-data" accept-charset="UTF-8">
			<div class="mt-2 row">
				<label for="username" class="col-2 col-form-label text-center  ms-3 ">User name</label>
				<div class="col-2">
					<input type="text" class="form-control text-center" id="username"
						placeholder="" name="user" readonly
						value="${sessionScope.accountInfo.nickname}">
				</div>
			</div>

			<div class="mt-2">
				<label for="title" class="form-label"></label> <input value="${p.p_title} " type="text"
					class="form-control" id="title" placeholder="제목을 입력해 주세요"
					name="title" required>
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
							name="img" required>
					</div>
				</div>

				<div class="mb-3">
					<label for="Textarea" class="form-label">본문</label>
					<textarea class="form-control" id="Textarea" rows="10" name="text"
						placeholder="20자 제한">${p.p_text}</textarea>
				</div>

				<div class="d-flex justify-content-end">
					<button name="no" value="${p.p_no}" class="btn btn-outline-success">수정</button>
				</div>
				</div>
		</form>
	</div>

	<footer class="my-5 pt-5 text-muted text-center text-small">
		<p class="mb-1">&copy; 2022 장식용</p>

	</footer>

</body>
</html>