<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TwitterSJ</title>
<link href="resources/gnb.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="Wrap">
		<div id="Header">${userId}님이 로그인 되었습니다.!!!</div>
		<div id="Menu">
			<a href="personal">목록보기</a><br /> <a href="/TwitterSJ/logout">logout</a>
		</div>
		<div id="Content">
			<table>
				<tbody>
					<c:forEach items="${postList}" var="post">
						<tr>
							<td>${post.photo}</td>
							<td>${post.sequenceNumber}</td>
							<td>${post.content}</td>
							<td><a href="remove?id=${post.sequenceNumber}">삭제</a></td>
							<td>${post.writeDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>