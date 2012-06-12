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
		<h1>Follower</h1>
		<p>
			<label>${user.name}(${user.description })</label>
			<a href="/twitter/service/write"><input type="button" value="글쓰기" /></a>
			<a href="/twitter/service/followingList"><input type="button" value="Following" /></a>
			<a href="/twitter/service/allUserList"><input type="button" value="전체사용자" /></a>
			<a href="/twitter/service/SNS"><input type="button" value="메인페이지" /></a>
			<a href="/twitter/logout"><input type="button" value="로그아웃" /></a>
		</p>
	</div>
		
	<div id="followerListContent">
		<c:forEach items="${followerList}" var="follow" >
			<div>
				<p> 
					<img src = "${follow.user.profileImg}" />
					<label>${follow.user.name}</label>
					<label>${follow.user.description}</label>
					
					<c:choose>
						<c:when test="${follow.state }">
							<a href="/twitter/service/unfollow?userNum=${follow.user.userNum}&url=/service/followerList">
								<input type="button" value="UnFollow" />
							</a>
						</c:when>
						<c:otherwise>
							<a href="/twitter/service/follow?userNum=${follow.user.userNum}&url=/service/followerList">
								<input type="button" value="Follow" />
							</a>
						</c:otherwise>
					</c:choose>
				</p>		
			</div>
		</c:forEach>
	</div>
</body>
</html>