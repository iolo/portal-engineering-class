<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSiggle</title>
<link href="/ssiggle/resources/css/common.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="/ssiggle/resources/css/joinUser.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="container">
		<div id="joinBox">
		<form:form modelAttribute="user" action="/ssiggle/saveUser"
			method="post" enctype="multipart/form-data">
			<h2>회원가입</h2>
			<p>
				<span>아이디</span>
				<form:input path="id" />
				<form:errors path="id" />
			</p>
			<p>
				<span>암호</span>
				<form:password path="password" />
				<form:errors path="password" />
			</p>
			<p>
				<span>이름</span>
				<form:input path="name" />
				<form:errors path="name" />
			</p>
			<p>
				<span>소개</span>
				<form:input path="introduce" />
				<form:errors path="introduce" />
			</p>
			<p>
				<span>이미지</span> <input name="imageFile" type="file">
			</p>
			<p class="btnBox">
				<input type="submit" value="가입" />
				<input type="reset" value="취소" />
			</p>
			<form:hidden path="image" />
		</form:form>
		</div>
	</div>
</body>
</html>