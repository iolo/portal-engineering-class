<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<table>
	<c:forEach items="${allUser}" var="target">
		<tr>
			<td><img src="/ssiggle/resources/userimage/${target.user.image}"
				width="50" height="50"></td>
			<td>${target.user.name }</td>
			<td>${target.user.introduce }</td>
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