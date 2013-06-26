<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty user}">
		<c:set value="/user/modifyProcess" var="actionUrl" />
	</c:when>
	<c:otherwise>
		<c:set value="/user/joinProcess" var="actionUrl" />
	</c:otherwise>
</c:choose>
<div id="wrap">
	<h1>회원정보</h1>
	<form action="<c:url value='${actionUrl}'/>" method="post" name="joinForm" id="joinForm">
	<table>
		<tr>
			<th><label for="id">ID</label></th>
			<td><input type="text" name="id" id="id" value="${user.id}" /></td>
		</tr>
		<tr>
			<th><label for="password">비밀번호</label></th>
			<td><input type="password" name="password" id="password" /></td>
		</tr>
		<tr>
			<th><label for="name">이름</label></th>
			<td><input type="text" name="name" id="name" value="${user.name}" /></td>
		</tr>
		<tr>
			<th><label for="etc">설명</label></th>
			<td><input type="text" name="etc" id="etc" value="${user.etc}" /></td>
		</tr>
	</table>
	<input type="submit" value="저장" />
	</form>
</div>
</body>
</html>