<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<form:form commandName="following" action="unfollow.do/follower">
	<c:if test="${f:length(alluserlist) gt 0}">
	<table>
	<tbody >
		<c:forEach items="${alluserlist}" var="alluser">
		<tr>
			<th class="img"><img src="/resources/profile/${alluser.id }"/></th>
			<th class="rounded"><c:out value="${alluser.id }" /><br>
			<c:out value="${alluser.name }" /><br>
			<c:out value="${alluser.profile }" />
			<th>
				<c:choose>
					<c:when test="${alluser.following}">
						<a href="unfollow.do/alluser?following=${alluser.id }">
							<input class="medium red bttn"  type="submit" value="UnFollowing">
						</a>
					</c:when>
					<c:otherwise>
						<a href="following.do/alluser?following=${alluser.id }">
							<input class="medium blue bttn"  type="submit" value="Following">
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
