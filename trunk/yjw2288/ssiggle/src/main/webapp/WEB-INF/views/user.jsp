<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSiggle</title>
<script type="text/javascript">
	function openNewWindow(window) {
		open(
				window,
				"NewWindow",
				"left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=280, height=200");
	}
</script>
<link href="/ssiggle/resources/css/common.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="/ssiggle/resources/css/user.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="container">
		<div class="header">
			<a class="profile">${user.id }(${user.introduce })</a>
			<a class="btn" href="/ssiggle/logout">로그아웃</a>
			<a class="btn"
				href="javascript:openNewWindow('/ssiggle/service/writeSsiggle?userId=${user.id}')">글쓰기</a>
			<a class="btn" href="/ssiggle/service/modifyUser?id=${user.id}">프로필 수정</a>
			<a class="btn" href="/ssiggle">메인 페이지</a>
		</div>
		<hr/>
		<table>
			<c:forEach items="${ssigglelist}" var="ssiggle">
				<tr>
					<td class="prof"><img src="/ssiggle/resources/userimage/${user.image}"
						width="50" height="50"></td>
					<td class="text">${ssiggle.text}</td>
					<td class="delete">
						<a class="btn" href="/ssiggle/service/deleteSsiggle?userId=${user.id}&ssiggleId=${ssiggle.id}">삭제</a>
					</td>
					<td class="time">${ssiggle.time}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
