<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
${title }  
<form:form action="deletetwitt.do">
<c:if test="${f:length(twittList) gt 0}">
	<c:forEach items="${twittList}" var="twittlist">
		<c:out value="${twittlist.name }"/>
		<c:out value="${twittlist.content }"/>
		<c:out value="${twittlist.write_date }"/>
		<c:out value="${twittlist.twinum }"/>
		<c:if test="${title == '나의 트윗' }">
			<input type="hidden" name="twinum" value="${twittlist.twinum }"/>
			<input type="submit" value="삭제"/>
		</c:if>
		<br>
	</c:forEach>
</c:if>
</form:form>
