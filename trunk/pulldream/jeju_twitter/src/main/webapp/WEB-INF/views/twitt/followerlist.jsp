<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<form:form commandName="following" action="unfollow.do/follower" >
FollowingList<br>
<c:if test="${f:length(followerList) gt 0}">
	<c:forEach items="${followerList}" var="follower">
		<c:out value="${follower.id }"/>
		<c:out value="${follower.name }"/>
		<c:out value="${follower.profile }"/>
		<c:choose>
			<c:when test="${follower.following}">
				<input type="submit" value="UnFollowing">
			</c:when>
			<c:otherwise><input type="submit" value="Following"></c:otherwise>
		</c:choose>
		<br>
	</c:forEach>
</c:if>
</form:form>
