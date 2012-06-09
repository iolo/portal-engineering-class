<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 수정</title>
	<link href="/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="Header">
		사용자 관리
	</div>
	<div id="Content">
		<form:form modelAttribute="loginUser" action="/service/update" method="post">
			<fieldset>
				<legend>사용자 수정</legend>
				<p>
					<label>아이디</label>
					<form:input path="loginId" readonly="true"/>
					<form:errors path="loginId" />
				</p>
				<p>
					<label>이름</label>
					<form:input path="username"/>
					<form:errors path="username" />
				</p>
				<p>
					<label>암호</label>
					<form:password path="password"/>
					<form:errors path="password" />
				</p>
				<p>
					<input type="submit" value="수정" />
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>
