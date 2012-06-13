<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
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
		<h1>SNS</h1>
		<p>
			<a href="/twitter/service/personalSNS"><label>${user.name}(${user.description })</label></a>
			<a href="javascript:void(window.open('/twitter/service/write', '글쓰기',
						'width=500, height=300'))"><input type="button" value="글쓰기" /></a>
			<a href="/twitter/service/followingList"><input type="button" value="Following" /></a>
			<a href="/twitter/service/followerList"><input type="button" value="Follower" /></a>
			<a href="/twitter/service/allUserList"><input type="button" value="전체사용자" /></a>
			<a href="/twitter/logout"><input type="button" value="로그아웃" /></a>
		</p>
	</div>
		
	<div id="SNSListContent">
		<c:forEach items="${UserTweets}" var="userTweet" >
			<div>
				<p>
					<img src = "${userTweet.user.profileImg}" />
					<label>${userTweet.user.name}</label>
					<label>${userTweet.tweet.message}</label>
					<label>${userTweet.tweet.date}</label>
				</p>		
			</div>
		</c:forEach>
	</div>
</body>
</html>