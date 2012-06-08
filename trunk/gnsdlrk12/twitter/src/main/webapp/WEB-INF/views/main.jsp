<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>메인 페이지</title>
</head>
<body>
	<div id="Header">
	</div>
	<div id="Content">
		<form:form modelAttribute="user" action="login" method="post">
			<fieldset>
				<h1 style="text-align:center">육식토끼의 twitter에 오신 것을 환영합니다.</h1>
				<p style="text-align:center">
					<label style="text-align:center">아이디 : </label>
					<form:input path="userid"/>
				</p>
				<p style="text-align:center">
					<label>패스워드 : </label>
					<form:password path="password"/>
				</p>
				<p style="text-align:center">
					<input type="submit" value="로그인" />
					<input type="button" value="회원가입" />
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>
