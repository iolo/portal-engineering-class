<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원 정보 수정</title>
	<!-- 
	<link href="/userㅁ/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	 -->
</head>
<body>
	<div id="ProfileContent">
		<form:form name="profileForm" modelAttribute="user" action="/twitter/service/profileSave" 
								method="post"  enctype="multipart/form-data" acceptCharset="UTR-8"> 
			<fieldset>
				<legend>사용자 정보 수정</legend>
				<form:hidden path="userNum"/>
				<p>
					<label>아이디</label>
					<form:input path="id" readonly="true" />
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
				<p>
					<label>설명</label>
					<form:input path="description"/>
				</p>
				<p>
					<label>프로필이미지</label>
					<form:hidden path="profileImg"/>
					<p>
						<input type="file" name="file"/>
					</p>
				</p>
				<p>
					<input type="submit" value="수정" />
					<input type="button" value="취소" onclick="javascript:history.back()">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>