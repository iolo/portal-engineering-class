<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSiggle</title>
<link href="/ssiggle/resources/css/common.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="/ssiggle/resources/css/login.css" rel="stylesheet" type="text/css"
	media="all" />
<link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" type="text/css" />
</head>
<body>
	<div id="container">
		<p class="title">시끌벅적 SNS에 오신것을 환영합니다!</p>
		<img class="mainImg" src="/ssiggle/resources/DukeWithHelmet.png" />
		<form action="/ssiggle/loginProcess" method="post">
		<div class="loginForm">
			<div>
				<div class="userId">아이디</div>
				<span class="uId"><input type="text" name="id"></span>
			</div>
			<div class="clear">
				<div class="userPw">비밀번호</div>
				<span class="psw"><input type="password" name="password"></span>
			</div>
			<div class="btnClass">
				<button type="submit" id="btn-primary" class="btn btn-primary">로그인</button>
			</div>
		</div>
		</form>
		<div class="joinFirst">
			처음 방문하세요?<a href="/ssiggle/joinUser" class="joinBtn">가입하기</a>
		</div>		
	</div>
</body>
</html>