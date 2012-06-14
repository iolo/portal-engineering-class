<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<form:form commandName="following" action="unfollow.do/follower">
FollowingList<br>

	<c:if test="${f:length(followingList) gt 0}">
	<table>
	<thead>
		<tr>
			<th>	</th>
			<th>아이디</th>
			<th>이 름</th>
			<th>프로필</th>
			<th>팔로우</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${followingList}" var="following">
		<tr>
			<th>IMAGE</th>
			<th><c:out value="${following.id }" /></th>
			<th><c:out value="${following.name }" /></th>
			<th><c:out value="${following.profile }" /></th>
			<th>
				<c:choose>
					<c:when test="${following.following}">
						<a href="unfollow.do/following?following=${following.id }">
							<input type="submit" value="UnFollowing">
						</a>
					</c:when>
					<c:otherwise>
						<a href="following.do/following?following=${following.id }">
							<input type="submit" value="Following">
						</a>
					</c:otherwise>
				</c:choose>
			</th>
		</tr>
		</c:forEach>
		</tbody>
		</table>
	</c:if>
</form:form>
