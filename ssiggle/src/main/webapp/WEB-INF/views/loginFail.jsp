<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Siggle</title>
</head>
<body>
	아이디나 비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.
	<form action="login" method="post">
		아이디 : <input type="text" name="id"><br /> 비밀번호 : <input
			type="password" name="password"><br /> <input type="submit"
			value="로그인" />
	</form>
</body>
</html>