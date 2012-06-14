<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TwitterSJ</title>
<link href="resources/css/gnb.css" rel="stylesheet" type="text/css"	media="all" />
<script language="javascript" src="/TwitterSJ/resources/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function openPopUp(window) {
		open(
				window,
				"NewWindow",
				"left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=280, height=200");
	}
	function navIn() {
		var imgSrc = $(this).attr("src");
		imgSrc = imgSrc.replace("_01.png", "_02.png");
		$(this).attr("src", imgSrc);
	}

	function navOut() {
		var imgSrc = $(this).attr("src");
		imgSrc = imgSrc.replace("_02.png", "_01.png");
		$(this).attr("src", imgSrc);
	}

	function init() {
		$("a img").mouseover(navIn);
		$("a img").mouseout(navOut);
	}

	$(window).ready(init);
</script>
</head>
<body>
	<div id="Wrap">
		<div id="Header">${user.userName} SNS Page</div>
		<div id="Menu">
			<a class="profile" href="modifyuser"> ${user.userName}(${user.introduce})</a>
			<a class="btn" href="/TwitterSJ/logout">로그아웃</a>
			<a href="javascript:openPopUp('/TwitterSJ/service/writePost')">글쓰기</a>
			<a class="btn" href="/TwitterSJ/service/following">Following</a>
			<a class="btn" href="/TwitterSJ/service/follower">Follower</a>
			<a class="btn" href="/TwitterSJ/service/alluser">전체페이지</a>
			<a class="btn" href="/TwitterSJ/service/personal">마이페이지</a>
		</div>
		<div id="Content">
			<table>
				<tbody>
					<c:forEach items="${follower}" var="user">
						<tr>
							<td><img src="/TwitterSJ/resources/images/${user.photo}"
								width="50" height="50"></td>
							<td>${user.userName}</td>
							<td>${user.introduce}</td>
							<td><a href=""><img src="/TwitterSJ/resources/follow_01.png" alt="followbtn" id="followbtn"/></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>