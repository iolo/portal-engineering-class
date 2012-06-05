<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Siggle</title>
</head>
<body>
	<form:form modelAttribute="user" action="/ssiggle/service/saveUser"
		method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>사용자 수정</legend>
			<p>
				<label>아이디</label>
				<form:input path="id" readonly="true" />
				<form:errors path="id" />
			</p>
			<p>
				<label>암호</label>
				<form:password path="password" />
				<form:errors path="password" />
			</p>
			<p>
				<label>이름</label>
				<form:input path="name" />
				<form:errors path="name" />
			</p>
			<p>
				<label>소개</label>
				<form:input path="introduce" />
				<form:errors path="introduce" />
			</p>
			<p>
				<label>이미지</label> <input name="imageFile" type="file">
			</p>
			<p>
				<form:hidden path="image" />
				<input type="submit" value="수정" />
			</p>
		</fieldset>
	</form:form>

</body>
</html>