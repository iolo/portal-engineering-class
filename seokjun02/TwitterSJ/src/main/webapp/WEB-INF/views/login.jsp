<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TwitterSJ</title>
<link href="resources/gnb.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id=Wrap>
		<div id="Header">TwitterSJ</div>
		<div id="Content">
			<form:form modelAttribute="user" action="login" method="post">
				<h1>TwitterSJ에 오신 것을 환영합니다!</h1>
				<p>
					<label>ID</label>
					<form:input path="userid" />
					<form:errors path="userid" />
				</p>
				<p>
					<label>Password</label>
					<form:password path="password" />
					<form:errors path="password" />
				</p>
				<p>
					<input type="submit" value="로그인" />
				</p>
				<p>
					<input type="button" value="회원가입" />
				</p>
			</form:form>
		</div>
	</div>
</body>
</html>
