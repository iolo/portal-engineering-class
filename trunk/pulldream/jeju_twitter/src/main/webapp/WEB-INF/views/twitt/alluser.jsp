<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<form:form commandName="following" action="unfollow.do/follower">
	<c:if test="${f:length(alluserlist) gt 0}">
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
		<c:forEach items="${alluserlist}" var="alluser">
		<tr>
			<th><img src="/resources/profile/${alluser.id }"/></th>
			<th><c:out value="${alluser.id }" /></th>
			<th><c:out value="${alluser.name }" /></th>
			<th><c:out value="${alluser.profile }" /></th>
			<th>
				<c:choose>
					<c:when test="${alluser.following}">
						<a href="unfollow.do/alluser?following=${alluser.id }">
							<input type="submit" value="UnFollowing">
						</a>
					</c:when>
					<c:otherwise>
						<a href="following.do/alluser?following=${alluser.id }">
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
