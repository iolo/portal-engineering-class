<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>댓글 시스템</h1>
	<c:choose>
		<c:when test="${not empty sessionScope.userLoginInfo}">
			<!--로그인-->
			${sessionScope.userLoginInfo.name} (${sessionScope.userLoginInfo.description})
			<a href="<c:url value='modify'/>">프로필수정</a>
			<a href="<c:url value='logout'/>">로그아웃</a>
		</c:when>
		<c:otherwise>
			<!--로그인 안됬을 때 -->
			<a href="<c:url value='join'/>">회원가입</a>
		</c:otherwise>
	</c:choose>

	<a href="<c:url value='login'/>">글쓰기</a>

	<table>
		<c:forEach var="result" items="${comments}" varStatus="status">
			<tr>
				<td><c:out value="${result.image}" /></td>
				<td><c:out value="${result.name}" /></td>
				<td><c:out value="${result.comment}" /></td>
				<td><c:out value="${result.likeCount}" /></td>
				<td><c:out value="${result.unlikeCount}" /></td>
				<td><c:out value="${result.regdate}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
