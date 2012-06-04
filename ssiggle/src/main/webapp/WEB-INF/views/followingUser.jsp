<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<table>
	<c:forEach items="${followingUser}" var="following">
		<tr>
			<td><img src="/ssiggle/resources/userimage/${following.image}"
				width="50" height="50"></td>
			<td>${following.name }</td>
			<td>${following.introduce }</td>
			<td><a
				href="/ssiggle/service/unFollow/followingPage?userId=${user.id}&targetId=${following.id}">언팔로우</a></td>
		</tr>
	</c:forEach>
</table>