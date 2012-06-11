<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
${title }  
<form:form>
<c:if test="${f:length(twittList) gt 0}">
	<c:forEach items="${twittList}" var="id">
		<c:out value="${id.name }"/>
		<c:out value="${id.content }"/>
		<c:out value="${id.write_date }"/><br>
	</c:forEach>
</c:if>
</form:form>
