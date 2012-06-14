<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<form:form commandName="following" action="unfollow.do/follower">
AllUserList<br>
	<c:if test="${f:length(alluserlist) gt 0}">
		<c:forEach items="${alluserlist}" var="alluser">
			<c:out value="${alluser.id }" />
			<c:out value="${alluser.name }" />
			<c:out value="${alluser.profile }" />
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
			<br>
		</c:forEach>
	</c:if>
</form:form>
