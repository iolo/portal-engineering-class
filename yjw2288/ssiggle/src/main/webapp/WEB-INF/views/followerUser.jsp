<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSiggle</title>
<link href="/ssiggle/resources/css/common.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="/ssiggle/resources/css/following.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" type="text/css" />
</head>
<body>
	<div id="container">
		<div class="header">
			<a class="profile" href="/ssiggle/service/user">${user.name}<br />(${user.introduce})</a>
			<a class="btn btn-primary" href="/ssiggle/logout">로그아웃</a> 
			<a class="btn btn-primary"
				href="/ssiggle/service/user/allUser">전체사용자</a> 
			<a class="btn btn-primary" href="/ssiggle/service/user/follower">follower</a>
			<a class="btn btn-primary" href="/ssiggle/service/user/following">following</a>
			<a class="btn btn-primary" href="/ssiggle">메인 페이지</a>
		</div>
		<hr/>
		<table>
		<c:forEach items="${followerUser}" var="target">
			<tr>
				<td class="prof"><img
					src="/ssiggle/resources/userimage/${target.user.image}" width="50px"
					height="50px"></td>
				<td class="name">${target.user.id}<br />( ${target.user.name } )</td>
				<td class="introduce">${target.user.introduce }</td>
				<td class="following">
				<c:choose>
					<c:when test="${target.following}">
						<a class="btn btn-danger"
							href="/ssiggle/service/unFollow?targetId=${target.user.id}">unfollow</a>
					</c:when>
					<c:otherwise>
						<a class="btn btn-success"
							href="/ssiggle/service/follow?targetId=${target.user.id}">follow</a>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>

