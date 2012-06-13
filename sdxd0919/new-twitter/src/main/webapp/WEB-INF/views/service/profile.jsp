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
<center>
	<div id="ProfileContent">
		<form:form name="profileForm" modelAttribute="user" action="/twitter/service/profileSave" 
								method="post"  enctype="multipart/form-data"> 
			<center>
			<fieldset>
				<legend>사용자 정보 수정</legend>
				<table align="left">
				<form:hidden path="userNum"/>
				<tr>
					<td width="100" align="left">아이디</td>
					<td width="200" align="left">
						<form:input path="id" readonly="true" />
					</td>
				</tr>
				<tr>
					<td width="100" align="left">이름</td>
					<td width="200" align="left">
						<form:input path="name"/>
						<form:errors path="name" />
					</td>
				</tr>
				<tr>
					<td width="100" align="left">암호</td>
					<td width="200" align="left">
						<form:password path="password"/>
						<form:errors path="password" />
					</td>
				</tr>
				<tr>
					<td width="100" align="left">설명</td>
					<td width="200" align="left">
						<form:input path="description"/>
					</td>
				</tr>
				<tr>
					<td width="100" align="left">프로필이미지</td>
					<td width="200" align="left">
						<form:hidden path="profileImg"/>
						<input type="file" name="file"/>
					</td>
				</tr>
				<tr>
					<td width="200" align="center">
						<input type="submit" value="수정" />
					</td>
					<td width="200" align="left">
						<input type="button" value="취소" onclick="javascript:history.back()">
					</td>
				</tr>
				</table>
			</fieldset>
			</center>
		</form:form>
	</div>
</center>
</body>
</html>