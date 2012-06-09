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
				"left=300, top=300, toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=280, height=200");
	}
</script>
<link href="/ssiggle/resources/css/common.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="/ssiggle/resources/css/main.css" rel="stylesheet" type="text/css"
	media="all" />
<title>Siggle</title>
</head>
<body>
	<div id="container">
		<div class="header">
			<a class="profile" href="/ssiggle/service/user/">${user.name}(${user.introduce })</a>
			<a class="btn" href="/ssiggle/logout">로그아웃</a>
			<a class="btn" href="/ssiggle/service/user/allUser">전체사용자</a>
			<a class="btn" href="/ssiggle/service/user/follower">follower</a>
			<a class="btn" href="/ssiggle/service/user/following">following</a>
			<a class="btn"
				href='javascript:openNewWindow("/ssiggle/service/writeSsiggle")'>글쓰기</a>
		</div>
		<hr/>
		<table>
			<c:forEach items="${ssiggleList}" var="ssiggle">
				<tr>
					<td class="prof"><img src=/ssiggle/resources/userimage/${ssiggle.user.image}
						width="50px" height="50px"></td>
					<td class="name">${ssiggle.user.name }</td>
					<td class="text" align="left">${ssiggle.text }</td>
					<td class="time">${ssiggle.time }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>