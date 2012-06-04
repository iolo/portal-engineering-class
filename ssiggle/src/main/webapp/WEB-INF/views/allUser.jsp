<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<table>
	<c:forEach items="${allUser}" var="target">
		<tr>
			<td><img src="/ssiggle/resources/userimage/${target.image}"
				width="50" height="50"></td>
			<td>${target.name }</td>
			<td>${target.introduce }</td>
			<td><a href="/ssiggle/service/follow/allUser?userId=${user.id}&targetId=${target.id}">follow</a></td>
		</tr>
	</c:forEach>
</table>