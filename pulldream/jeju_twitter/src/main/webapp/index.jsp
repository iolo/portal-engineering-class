<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form method="post" action="login.do">
			<input type="text" placeholder="아이디 입력" name="id">	
			<input type="password" placeholder="비밀번호 입력" name="password"><br>			
   			<input type="submit" value="로그인"/>s
   			<!-- <input type="button" value="회원가입" onclick="window.open('joinform')"/> -->
   			<a href="joinform"><input type="button" value="회원가입"></a>
</form>
</body>
</html>