<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TwitterSJ</title>
<link href="resources/css/gnb.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript">
	function openPopUp(window) {
		open(
				window,
				"NewWindow",
				"left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=280, height=200");
	}
</script>
</head>
<body>
	<div id="Wrap">
		<div id="Header">${user.userName} SNS Page</div>
		<div id="Menu">
			<a class="profile"> ${user.userName}(${user.introduce})</a>
			<a class="btn" href="/TwitterSJ/logout">로그아웃</a>
			<a href="javascript:openPopUp('/TwitterSJ/service/writePost')">글쓰기</a>
			<a class="btn" href="modifyuser">정보수정</a>
			<a class="btn" href="personal">전체페이지</a>
		</div>
		<div id="Content">
			<table>
				<tbody>
					<c:forEach items="${postList}" var="post">
						<tr>
							<td><img src="/TwitterSJ/resources/images/${post.photo}"
								width="50" height="50"></td>
							<td>${post.sequenceNumber}</td>
							<td>${post.content}</td>
							<td><a href="deleteUserPost?sequenceNumber=${post.sequenceNumber}">삭제</a></td>
							<td>${post.writeDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>