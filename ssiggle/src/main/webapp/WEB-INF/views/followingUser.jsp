<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Siggle</title>
</head>
<body>
<table>
	<c:forEach items="${followingUser}" var="following">
		<tr>
			<td><img src="/ssiggle/resources/userimage/${following.image}"
				width="50" height="50"></td>
			<td>${following.name }</td>
			<td>${following.introduce }</td>
			<td><a
				href="/ssiggle/service/unFollow/followingPage?userId=${user.id}&targetId=${following.id}">언팔로우</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>