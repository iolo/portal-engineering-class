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
		<h1>Following</h1>
		<p>
			<label>${user.name}(${user.description })</label>
			<a href="/twitter/service/followerList"><input type="button" value="Follower" /></a>
			<a href="/twitter/service/allUserList"><input type="button" value="전체사용자" /></a>
			<a href="/twitter/service/SNS"><input type="button" value="메인페이지" /></a>
			<a href="/twitter/logout"><input type="button" value="로그아웃" /></a>
		</p>
	</div>
		
	<div id="followingListContent">
		<c:forEach items="${followingList}" var="followingUser" >
			<div>
				<p> 
					<img src = "${followingUser.profileImg}" />
					<label>${followingUser.name}</label>
					<label>${followingUser.description}</label>
					<a href="/twitter/service/unfollow?userNum=${followingUser.userNum}&url=/service/followingList">
							<input type="button" value="UnFollow" />
					</a>
				</p>		
			</div>
		</c:forEach>
	</div>
</body>
</html>