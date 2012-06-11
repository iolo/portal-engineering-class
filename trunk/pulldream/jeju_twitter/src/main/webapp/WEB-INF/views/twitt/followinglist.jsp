<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<form:form modelÅttribute="asdf" action="unfollow.do" >
FollowingList<br>
<c:if test="${f:length(followingList) gt 0}">
	<c:forEach items="${followingList}" var="following">
		<img src="resources/profile/a"><c:out value="${following.following }"/><br>
		<form:hidden path="following" value="${following.following }"/>
		<input type="submit" value="unfollow" />
	</c:forEach>
</c:if>
</form:form>
