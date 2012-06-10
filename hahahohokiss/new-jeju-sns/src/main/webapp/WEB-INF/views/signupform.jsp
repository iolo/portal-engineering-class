<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="Content">
		<form method="post" action="/signup" enctype="multipart/form-data">
			<fieldset>
				<legend>사용자 등록</legend>
				<p>
					<label>아이디</label>
					<input type="text" name="loginId" />
				</p>
				<p>
					<label>이름</label>
					<input type="name" name="username" />
				</p>
				<p>
					<label>암호</label>
					<input type="password" name="password" />
				</p>
				<p>
					<label>설명</label>
					<input type="text" name="explanation" />
				</p>
				<p>
					<label>프로필이미지</label>
					<input type="file" name="file">
				</p>
				<p>
					<input type="submit" value="등록" />
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>