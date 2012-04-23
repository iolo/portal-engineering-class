<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 수정</title>
	<link href="/usermanager/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="Header">
		사용자 관리
	</div>
	<div id="Menu">
		<a href="list">목록보기</a><br/>
		<a href="create.jeju">수정하기</a>
	</div>
	<div id="Content">
		<form:form modelAttribute="user" action="save" method="post">
			<fieldset>
				<legend>사용자 수정</legend>
				<p>
					<label>아이디</label>
					<form:input path="id"/>
					<form:errors path="id" />
				</p>
				<p>
					<label>이름</label>
					<form:input path="name"/>
					<form:errors path="name" />
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
