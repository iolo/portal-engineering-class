<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/resources/css/main.css" rel="stylesheet" type="text/css" media="all" />
<link href="/resources/css/button.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<p><img class="myphoto" width="800px" hieght="600px" src="/resources/profile/DSC_0546.JPG"/></p>
<form method="post" action="login.do">
<p>
			<input type="text" placeholder="아이디 입력" name="id">	
			<input type="password" placeholder="비밀번호 입력" name="password"><br>			
   			<input  class="medium blue bttn" type="submit" value="로그인"/>
   			<a href="joinform"><input  class="medium blue bttn" type="button" value="회원가입"></a>
   			
   			</p>
</form>
</body>
</html>