<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Siggle</title>
<link href="/ssiggle/resources/css/common.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="/ssiggle/resources/css/following.css" rel="stylesheet"
	type="text/css" media="all" />
</head>
<body>
	<div id="container">
		<div class="header">
			<a class="profile" href="/ssiggle/service/user/${user.id}">${user.name}(${user.introduce})</a>
			<a class="btn" href="/ssiggle/logout">로그아웃</a> 
			<a class="btn"
				href="/ssiggle/service/user/${user.id}/allUser">전체사용자</a> 
			<a class="btn" href="/ssiggle/service/user/${user.id}/follower">follower</a>
			<a class="btn" href="/ssiggle/service/user/${user.id}/following">following</a>
		</div>
		<hr/>
		<table>
		<c:forEach items="${followerUser}" var="follower">
			<tr>
				<td class="prof"><img
					src="/ssiggle/resources/userimage/${follower.user.image}" width="50px"
					height="50px"></td>
				<td class="name">${follower.user.name }</td>
				<td class="introduce">${follower.user.introduce }</td>
				<td class="following">
				<c:choose>
					<c:when test="${target.following}">
						<a class="btn"
							href="/ssiggle/service/unFollow/allUser?userId=${user.id}&targetId=${target.user.id}">unfollow</a>
					</c:when>
					<c:otherwise>
						<a class="btn"
							href="/ssiggle/service/follow/allUser?userId=${user.id}&targetId=${target.user.id}">follow</a>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>

