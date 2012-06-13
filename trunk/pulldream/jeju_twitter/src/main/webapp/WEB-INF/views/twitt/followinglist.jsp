<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<form:form commandName="following" action="unfollow.do" >
FollowingList<br>



<c:if test="${f:length(followingList) gt 0}">
	<c:forEach items="${followingList}" var="following">
		<img src="/resources/profile/${following.path }"/>
		<c:out value="${following.following }"/>
		<c:out value="${following.name }"/>
		<c:out value="${following.profile }"/>
		<a href="unfollow.do?following=${following.following }"><input type="button" value="unfollow"/></a>
		<br>
	</c:forEach>
</c:if>
</form:form>
