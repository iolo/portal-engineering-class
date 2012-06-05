<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form modelAttribute="user" action="saveuser" method="post">
	<fieldset>
		<legend>사용자 수정</legend>
		<p>
			<label>아이디</label>
			<form:input path="id" readonly="true" />
			<form:errors path="id" />
		</p>
		<p>
			<label>이름</label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			<label>암호</label>
			<form:password path="password" />
			<form:errors path="password" />
		</p>
		<p>
			<input type="submit" value="수정" />
		</p>
	</fieldset>
</form:form>