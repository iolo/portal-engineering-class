<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
<div id="MainImage" align="center">
	<img src="/resources/images/main_image.jpg" width="800" height="500">
</div>


<div id="LoginContent">
		<form action="/sign" method="post">
			<fieldset>
				<legend>Login</legend>
				<p>
					<label>ID</label>
					<input type="text" name="userId" />
				</p>
				<p>
					<label>Password</label>
					<input type="password" name="password" />
				</p>
				<p>
					<input type="submit" value="로그인" />
					<a href="/signupform"><input type="button" value="회원가입" /></a>
				</p>
			</fieldset>
		</form>
	</div>
	</body>
</html>
