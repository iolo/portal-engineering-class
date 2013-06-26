<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글</title>
</head>
<body>
<div id="wrap">
	<h1>댓글</h1>
	<div id="menu">
		<c:choose>
			<c:when test="${not empty sessionScope.user}">
				<strong>${sessionScope.user.name}님 (${sessionScope.user.etc})</strong>
				<a href="<c:url value='/user/modify'/>">프로필수정</a>
				<a href="<c:url value='/write'/>">글쓰기</a>
				<a href="<c:url value='/logout'/>">로그아웃</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/user/join'/>">회원가입</a>
				<a href="<c:url value='/write'/>">글쓰기</a>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="replyList">
		<c:forEach items="${replyList}" var="reply" varStatus="status">
			<div class="reply">
				<img src="" alt="비어있음" />
				<span>${reply.name}</span>
				<span>${reply.content}</span>
				<c:if test="${reply.id == sessionScope.user.id}">
					<a href="<c:url value='/delete'/>?no=${reply.no}">[삭제]</a>
				</c:if>
				<span>${reply.insertDate}</span>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>