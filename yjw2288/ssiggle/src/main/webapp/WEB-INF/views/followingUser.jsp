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
		<c:forEach items="${followingUser}" var="following">
			<tr>
				<td class="prof"><img src="/ssiggle/resources/userimage/${following.image}"
					width="50px" height="50px"></td>
				<td class="name">${following.name }</td>
				<td class="introduce">${following.introduce }</td>
				<td class="following"><a class="btn"
					href="/ssiggle/service/unFollow/followingPage?userId=${user.id}&targetId=${following.id}">언팔로우</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>