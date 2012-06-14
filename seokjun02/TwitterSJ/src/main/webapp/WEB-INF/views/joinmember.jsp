<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TwitterSJ Join Member</title>
<link href="resources/css/gnb.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="resources/css/join.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="Wrap">
		<div id="Content">
			<h1>회원가입</h1>
			<form:form modelAttribute="user" action="joinSubmit" method="post" enctype="multipart/form-data">
				<p>
					<span class="labelName">ID</span>
					<form:input path="userId" cssClass="inputBox"/>
					<form:errors path="userId" />
				</p>
				<p>
					<span class="labelName">Password</span>
					<form:password path="password" cssClass="inputBox" />
					<form:errors path="password" />
				</p>
				<p>
					<span class="labelName">이름</span>
					<form:input path="userName" cssClass="inputBox" />
					<form:errors path="userName" />
				</p>
				<p>
					<span class="labelName">설명</span>
					<form:input path="introduce" cssClass="inputBox" />
					<form:errors path="introduce" />
				</p>
				<p>
					<span class="labelName">프로필이미지</span> <input type="file" name=profileImage class="inputBox" />
				</p>
				<p id="btnTag">
					<input type="submit" value="가입" />
					<input type="reset"	value="Reset" />
				</p>
				<form:hidden path="photo" />
			</form:form>
		</div>
	</div>
</body>
</html>