<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Siggle</title>
<script type="text/javascript">
	function openNewWindow(window) {
		open(
				window,
				"NewWindow",
				"left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=200, height=200");
	}
</script>

</head>
<body>
	개인페이지
	<br /> ${user.id } (${user.introduce })
	<a href="/ssiggle/service/modifyUser?id=${user.id}">프로필 수정</a>
	<a
		href='javascript:openNewWindow("/ssiggle/service/writeSsiggle?userId=${user.id}")'>글쓰기</a>
	<br />
	<table id="usertable" border='1'>
		<tbody>
			<c:forEach items="${ssigglelist}" var="ssiggle">
				<tr>
					<td><img src="/ssiggle/resources/userimage/${user.image}"
						width="50" height="50"></td>
					<td>${ssiggle.text}</td>
					<td><a
						href="/ssiggle/service/deleteSsiggle?userId=${user.id}&ssiggleId=${ssiggle.id}">삭제</a></td>
					<td>${ssiggle.time}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/ssiggle/logout">로그아웃</a>
</body>
</html>
