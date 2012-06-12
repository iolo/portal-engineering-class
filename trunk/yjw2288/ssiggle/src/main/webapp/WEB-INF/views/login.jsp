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
</head>
<body>
	<div id="container">
		<p class="title">시끌벅적 SNS에 오신것을 환영합니다!</p>
		<img class="mainImg" src="/ssiggle/resources/DukeWithHelmet.png" />
		<form action="/ssiggle/loginProcess" method="post">
		<div class="loginForm">
			<table class="loginForm">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
					<td rowspan="2"><input type="submit"	value="로그인" style="height: 50px; width: 60px; "/> </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
		</div>
		</form>
		<p>처음 방문하세요?<a href="/ssiggle/joinUser" class="joinBtn">가입하기</a></p>		
	</div>
</body>
</html>