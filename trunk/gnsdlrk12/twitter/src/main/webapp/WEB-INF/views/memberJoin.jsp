<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 등록</title>
</head>
<body>
	<div id="Header">
		사용자 등록
	</div>
	<div>
		<form action="/join"  method="post"  enctype="multipart/form-data">
			<fieldset>
				<legend>회원가입</legend>
				<p>
					<label>ID </label>
					<input type="text" name="userid" />
				</p>
				<p>
					<label>Password </label>
					<input type="password" name="password" />
				</p>
				<p>
					<label>이름 </label>
					<input type="name" name="name" />
				</p>
				<p>
					<label>설명 </label>
					<input type="text" name="information" />
				</p>
				<p>
					<label>프로필이미지 </label>
					<input type="file" name="image" />
				</p>
				<p>
					<input type="submit" value="등록" />
					<input type="button" value="취소" onclick="location.href='/'" />
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>