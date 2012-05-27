<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>개인 SNS</title>
	<!-- 
	<link href="/user/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	-->
</head>
<body>
	<div id="Header">
		<p>
			<label id="${user.userName}"></label>
			<a href="/twitter/join"><input type="button" value="프로필수정" /></a>
			<a href="/twitter/write"><input type="button" value="글쓰기" /></a>
			<a href="/twitter/SNS"><input type="button" value="메인페이지" /></a>
		</p>
	</div>
		
	<div id="PersonalListContent">
		<c:forEach items="${messageList}" var="message" >
			<form action="messageDelete" method="post">
				<input type="hidden" value="${message.num}">
 				<img src = "${user.profileImg}" />
				<label>${message.msg}</label>
				<input type="submit" value="삭제" />
				<label>${message.date}</label>
			</form>
		</c:forEach>
	</div>
</body>
</html>