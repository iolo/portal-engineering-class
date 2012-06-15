<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<form:form action="deletetwitt.do">
${title }
	<c:if test="${f:length(twittList) gt 0}">
	<table>
	<thead>
		<tr>
			<th>	</th>
			<th>이 름</th>
			<th>내 용</th>
			<th width="100">작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${twittList}" var="twittlist">
		<tr>
			<th><img src="/resources/profile/${twittlist.id }"/></th>
			<th><c:out value="${twittlist.name }" /></th>
			<th class="rounded"><c:out value="${twittlist.content }" /></th>
			<th width="100"><c:out value="${twittlist.write_date }" /></th>
			<th>		
				<c:if test="${title == '나의 트윗' }">
					<input  type="hidden" name="twinum" value="${twittlist.twinum }"/>
					<input class="medium red bttn"  type="submit" value="삭제"/>
				</c:if>
			</th>
		</tr>
		</c:forEach>
		</tbody>
		</table>
	</c:if>
</form:form>
