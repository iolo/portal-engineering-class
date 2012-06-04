<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<script type="text/javascript">
	function openNewWindow(window) {
		open(
				window,
				"NewWindow",
				"left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=200, height=200");
	}
</script>

<a href="/ssiggle/service/user/${user.id}">${user.name}</a>
<a
	href='javascript:openNewWindow("/ssiggle/service/writeSsiggle?userId=${user.id}")'>글쓰기</a>
<a href="/ssiggle/service/user/${user.id}/following">following</a>
<a href="/ssiggle/service/user/${user.id}/follower">follower</a>
<a href="/ssiggle/service/allUser">전체사용자</a>
<br />
<table>
<c:forEach items="${ssiggleList}" var="ssiggle">
	<tr>
		<td>${ssiggle. }
	</tr>
</c:forEach>
</table>

<a href="/ssiggle/logout">로그아웃</a>

