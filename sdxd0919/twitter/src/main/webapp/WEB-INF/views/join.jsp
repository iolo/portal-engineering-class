<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원 가입</title>
	<!-- 
	<link href="/userㅁ/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	 -->
</head>
<body>
	<div id="JoinContent">
		<form action="userAdd" method="post">
			<fieldset>
				<legend>사용자 등록</legend>
				<p>
					<label>ID</label>
					<input type="text" name="id" />
				</p>
				<p>
					<label>Password</label>
					<input type="password" name="password" />
				</p>
				<p>
					<label>이름</label>
					<input type="name" name="name" />
				</p>
				<p>
					<label>설명</label>
					<input type="text" name="description" />
				</p>
				<p>
					<label>프로필이미지</label>
					<input type="text" name="fropileImg" />
					<a href="/img"><input type="button" value="찾아보기" /></a>
				</p>
				<p>
					<input type="submit" value="회원가입" />
					<a href="/login"><input type="button" value="취소" /></a>
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>