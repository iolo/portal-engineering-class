<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<table>
	<c:forEach items="${allUser}" var="user">
		<tr>
			<td><img src="/ssiggle/resources/userimage/${user.image}"
				width="50" height="50"></td>
			<td>${user.name }</td>
			<td>${user.introduce }</td>
			<td><a href="/ssiggle/follow?userId=${user.id}">follow</a></td>
		</tr>
	</c:forEach>
</table>