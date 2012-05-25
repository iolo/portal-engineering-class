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
			<label id="${userName}"></label>
			<a href="/join"><input type="button" value="프로필수정" /></a>
			<a href="/write"><input type="button" value="글쓰기" /></a>
			<a href="/sns"><input type="button" value="메인페이지" /></a>
		</p>
	</div>
		
	<div id="PersonalListContent">
		<c:forEach items="${messageList}" var="message" >
			<div>
				<p>
					<img src = "${profileImg}" />
					<label>${msg}</label>
					<a href="/delete"><input type="button" value="삭제" /></a>
					<label>${date}</label>
				</p>		
			</div>
		</c:forEach>
	</div>
</body>
</html>