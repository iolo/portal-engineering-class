<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TwitterSJ Join Member</title>
<link href="resources/gnb.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/join.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="Header">
		<span id="pageTitle">회원가입</span>
	</div>
	<div id="Content">

		<form:form modelAttribute="user" action="joinSubmit" method="post"
			enctype="multipart/form-data">
			<p>
				<span>ID</span>
				<form:input path="userId" />
				<form:errors path="userId" />
			</p>
			<p>
				<span>Password</span>
				<form:password path="password"/>
				<form:errors path="password"/>
			</p>
			<p>
				<span>이름</span>
				<form:input path="userName" />
				<form:errors path="userName" />
			</p>
			<p>
				<span>설명</span>
				<form:input path="introduce" />
				<form:errors path="introduce" />
			</p>
			<p>
				<label>프로필이미지</label> <input type="file" name=profileImage />
			</p>
			<p>
				<input type="submit" value="가입" />
				<input type="reset" value="Reset" />
			</p>
			<form:hidden path="photo"/>
		</form:form>
	</div>
</body>
</html>