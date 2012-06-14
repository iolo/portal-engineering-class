<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
FollowingList
<br>
<form:form commandName="following" action="unfollow.do/following">
	<c:if test="${f:length(followingList) gt 0}">
		<c:forEach items="${followingList}" var="following">
			<%-- 		<img src="/resources/profile/${following.path }"/> --%>
			<c:out value="${following.id }" />
			<c:out value="${following.name }" />
			<c:out value="${following.profile }" />
			<a href="unfollow.do/following?following=${following.id }">
				 <input	type="submit" value="UnFollow" />
			</a>
			<br>
		</c:forEach>
	</c:if>
</form:form>
