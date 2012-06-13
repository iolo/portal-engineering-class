<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 등록</title>
</head>
<body>
	<div id="Header">
		사용자 등록
	</div>
	<div>
		<form:form modelAttribute="user" action="/userjoin" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>회원가입</legend>
				<p>
					<label>ID </label>
					<form:input path="userid"/>
				</p>
				<p>
					<label>Password </label>
					<form:password path="password"/>
				</p>
				<p>
					<label>이름 </label>
					<form:input path="name"/>
				</p>
				<p>
					<label>설명 </label>
					<form:input path="introduce"/>
				</p>
				<p>
					<label>프로필이미지 </label>
					<input name="image" type="file">
				</p>
				<p>
					<input type="submit" value="등록" />
					<input type="button" value="취소" onclick="location.href='/'" />
				</p>
				<form:hidden path="imageURL" />
			</fieldset>
			
		</form:form>
	</div>
</body>
</html>