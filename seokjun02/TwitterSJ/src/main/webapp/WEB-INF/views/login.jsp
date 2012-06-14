<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TwitterSJ</title>
<link href="resources/css/gnb.css" rel="stylesheet"/>
<link href="resources/css/login.css" rel="stylesheet"/>
</head>
<body>
	<div id=Wrap>
		<div id="Content">
			<div id="loginImg">
				<img alt="Hi! 방가방가!" src="resources/haha.jpg"/>
			</div>

			<form:form modelAttribute="user" action="login" method="post"
				id="loginForm">
				<h1>TwitterSJ에 오신 것을 환영합니다!</h1>
				<label>ID</label>
				<form:input path="userId" />
				<form:errors path="userId" />
				<label>Password</label>
				<form:password path="password" />
				<form:errors path="password" />
				<input type="submit" value="로그인" />
				<input type="button" value="회원가입"
					onclick="javascript:location.href='/TwitterSJ/joinmember'" />
			</form:form>
		</div>
	</div>
</body>
</html>
