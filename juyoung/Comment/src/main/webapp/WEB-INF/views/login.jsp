<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login</title>
</head>
<body>
	<h1>login 해 주세요</h1>
	<form name="loginInput" action="./login.check" method="post">
		ID<input type="text" name="userId"><br /> ${pre} Password<input
			type="text" name="userPassword"><br /> <input type="hidden"
			name="pre" value="${pre}">
		<button type="submit">로그인</button>
	</form>
	
	<button onclick="location.href='http://localhost:8080/jejunu/list'">취소</button>
</body>
</html>