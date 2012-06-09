<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>개인 SNS</title>
</head>
<body>
	<div id="Header">
		<p>
			<label id="${loginUser.username}"></label>
			<a href="/service/userform"><input type="button" value="프로필수정" /></a>
			<a href="javascript:window.open('/service/tweetWriteForm', 'test','width=300, height=70')"><input type="button" value="글쓰기" /></a>
			<a href="/sns"><input type="button" value="메인페이지" /></a>
		</p>
	</div>
		
	<div id="PersonalListContent">
		<c:forEach items="${tweets}" var="tweet" >
 				<img src = "${loginUser.imgUrl}" />
				<label>${tweet.contents}</label>
				<a href="/serivce/delete?tweetId=${tweet.tweetId }">삭제</a>
				<label>${tweet.date}</label>
		</c:forEach>
	</div>
</body>
</html>