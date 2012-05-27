<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<!-- 
	<link href="/user/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	-->
</head>
<body>
	<div id="Header">
		<p>
			<label id="username"></label>
			<a href="/twitter/join"><input type="button" value="프로필수정" /></a>
			<a href="/twitter/write"><input type="button" value="글쓰기" /></a>
			<a href="/twitter/userlist"><input type="button" value="Following" /></a>
			<a href="/twitter/userlist"><input type="button" value="Follower" /></a>
			<a href="/twitter/userlist"><input type="button" value="전체사용자" /></a>
		</p>
	</div>
		
	<div id="userListContent">
		<c:forEach items="${userlists}" var="user" >
			<div>
				<p>
					<img src = "${profileImg}" />
					<label>${name}</label>
					<label>${description}</label>
					<!-- 
					<c:if memo="${ }">
						<a href="/twitter/follow"><input type="button" value="Follow" /></a>
					</c:if>
					<c:if memo="${}">
						<a href="/twitter/unfollow"><input type="button" value="UnFollow" /></a>
					</c:if>
					 -->
				</p>		
			</div>
		</c:forEach>
	</div>
</body>
</html>