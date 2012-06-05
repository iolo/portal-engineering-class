<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Siggle</title>
</head>
<body>
<table>
	<c:forEach items="${followerUser}" var="follower">
		<tr>
			<td><img
				src="/ssiggle/resources/userimage/${follower.user.image}" width="50"
				height="50"></td>
			<td>${follower.user.name }</td>
			<td>${follower.user.introduce }</td>
			<c:choose>
				<c:when test="${target.following}">
					<td><a
						href="/ssiggle/service/unFollow/allUser?userId=${user.id}&targetId=${target.user.id}">unfollow</a></td>
				</c:when>
				<c:otherwise>
					<td><a
						href="/ssiggle/service/follow/allUser?userId=${user.id}&targetId=${target.user.id}">follow</a></td>
				</c:otherwise>
			</c:choose>
		</tr>
	</c:forEach>
</table>
</body>
</html>

