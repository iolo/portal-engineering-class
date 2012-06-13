<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
<title>Login Page</title>
</head>
<body>
	<div id = "LoginImage">
		<img src="/resources/Image/index.png" />
	</div>
	<div class ="LoginPannel">
	<form action="index/login" method="post">
		
			<p>
				<label>ID</label>
				<input type="text" name="id" />
			</p>
			<p>
				<label>PW</label>
				<input type="password" name="password" />
			</p>
			<p id ="LoginButton">
				<input type="submit" value="로그인" />
				
					<input type="button" value="회원가입"
						onclick="location.href='/create'" />
			</p>
	
	</form>
	</div>
	
</body>
</html>