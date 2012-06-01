<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form modelAttribute="user" action="saveUser" method="post"
	enctype="multipart/form-data">
	<fieldset>
		<legend>가입</legend>
		<p>
			<label>아이디</label>
			<form:input path="id" />
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
			<form:hidden path="image"/>
			<input type="submit" value="수정" />
		</p>
	</fieldset>
</form:form>
