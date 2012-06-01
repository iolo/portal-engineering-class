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
	<div>
		프로필 수정
	</div>
	<div>
		<form:form modelAttribute="user" action="modify" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>사용자 수정</legend>
				<p>
					<label>아이디</label>
					<label>${user.id}</label>
				</p>
				<p>
					<label>암호</label>
					<form:password path="password"/>
					<form:errors path="password" />
				</p>
				<p>
					<label>이름</label>
					<form:input path="name"/>
					<form:errors path="name" />
				</p>
				<p>
					<label>설명</label>
					<form:input path="information"/>
					<form:errors path="information" />
				</p>
				<p>
					<label>프로필 이미지</label>
					<input type="file" name="profileImage" />
				</p>
				<p>
					<input type="submit" value="수정" />
					<input type="button" value="취소"  onclick="location.href='/personal'" ; />
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>
