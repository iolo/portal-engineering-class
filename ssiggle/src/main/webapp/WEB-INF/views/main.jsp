<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function openNewWindow(window) {
		open(
				window,
				"NewWindow",
				"left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=200, height=200");
	}
</script>
<title>Siggle</title>
</head>
<body>
	<a href="/ssiggle/service/user/${user.id}">${user.name}</a>
	<a
		href='javascript:openNewWindow("/ssiggle/service/writeSsiggle?userId=${user.id}")'>글쓰기</a>
	<a href="/ssiggle/service/user/${user.id}/following">following</a>
	<a href="/ssiggle/service/user/${user.id}/follower">follower</a>
	<a href="/ssiggle/service/user/${user.id}/allUser">전체사용자</a>
	<br />
	<table>
		<c:forEach items="${ssiggleList}" var="ssiggle">
			<tr>
				<td><img src=/ssiggle/resources/userimage/${ssiggle.user.image}
					width="50" height="50"></td>
				<td>${ssiggle.user.name }</td>
				<td>${ssiggle.text }</td>
				<td>${ssiggle.time }</td>
			</tr>
		</c:forEach>
	</table>

	<a href="/ssiggle/logout">로그아웃</a>
</body>
</html>