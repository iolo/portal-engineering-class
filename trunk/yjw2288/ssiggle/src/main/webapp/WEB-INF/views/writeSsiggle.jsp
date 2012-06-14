<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" type="text/css" />
<title>Ssiggle</title>
</head>
<body>
	<form:form modelAttribute="ssiggle" action="/ssiggle/service/saveSsiggle"
		method="post" style="margin: 0 20px;">
		<fieldset>
			<legend>요즘 어떠신가요?</legend>
			<p>
				<form:textarea path="text" />
				<form:errors path="text" />
				<form:hidden path="user.id"/>
			</p>
			<p>
				<input class="btn btn-primary" type="submit" value="등록" />
				<button class="btn btn-primary" onclick="window.close();">취소</button>
			</p>
		</fieldset>
	</form:form>
</body>
</html>