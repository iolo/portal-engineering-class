<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<table>
	<c:forEach items="${followerUser}" var="follower">
		<tr>
			<td><img src="/ssiggle/resources/userimage/${follower.image}"
				width="50" height="50"></td>
			<td>${follower.name }</td>
			<td>${follower.introduce }</td>
			<td><a
				href="/ssiggle/service/user/follow/followerPage?userId=${user.id}&targetId=${follower.id}">팔로우</a></td>
		</tr>
	</c:forEach>
</table>