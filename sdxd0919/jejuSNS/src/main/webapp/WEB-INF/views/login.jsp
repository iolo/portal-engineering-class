<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>메인화면</title>
	<link href="/user/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="Header">
		<label>제주 SNS 오신것을 환영합니다.</label>
		<!--  <img src="/mainImg" />	-->
	</div>
	<div id="LoginContent">
		<form action="login" method="post">
			<fieldset>
				<legend>Login</legend>
				<p>
					<label>ID</label>
					<input type="text" name="id" />
				</p>
				<p>
					<label>Password</label>
					<input type="password" name="password" />
				</p>
				<p>
					<input type="submit" value="로그인" />
					<a href="/join"><input type="button" value="회원가입" /></a>
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>