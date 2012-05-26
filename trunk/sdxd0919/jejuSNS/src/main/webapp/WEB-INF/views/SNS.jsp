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
			<a href="/personalSNS"><label id="${user.userName}"></label></a>
			<a href="/write"><input type="button" value="글쓰기" /></a>
			<a href="/userlist"><input type="button" value="Following" /></a>
			<a href="/userlist"><input type="button" value="Follower" /></a>
			<a href="/userlist"><input type="button" value="전체사용자" /></a>
		</p>
	</div>
		
	<div id="SNSListContent">
		<c:forEach items="${messagelists}" var="message" >
			<div>
				<p>
					<img src = "${message.userid.profileImg}" />
					<label>${message.userid.name}</label>
					<label>${message.content}</label>
					<label>${message.date}</label>
				</p>		
			</div>
		</c:forEach>
	</div>
</body>
</html>