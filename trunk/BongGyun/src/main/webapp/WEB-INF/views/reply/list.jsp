<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글 시스템</title>
<script type="text/javascript">
function writePopup() {
	window.open(
		"<c:url value='/write'/>",
		"asdfs",
		"menubar=no,width=400,height=160,toolbar=no"
	);
}
</script>
</head>
<body>
	<!-- 회원정보, 메뉴버튼 부분 시작 -->
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
			<!-- 로그인 상태 -->
			${sessionScope.user.name} (${sessionScope.user.description})
			<a href="<c:url value='/modifyUser'/>">프로필수정</a>
			<a href="#WRITE" onclick="writePopup();">글쓰기</a>
			<a href="<c:url value='/logout'/>">로그아웃</a>
		</c:when>
		<c:otherwise>
			<!-- 비로그인 상태 -->
			<a href="<c:url value='/join'/>">회원가입</a>
			<a href="<c:url value='/login'/>">글쓰기</a>
		</c:otherwise>
	</c:choose>
	<!--// 회원정보, 메뉴버튼 부분 끝 -->
	<hr>
	<!-- 댓글 리스트 부분 시작 -->
	<table>		 
	<c:forEach items="${replyList}" var="reply" varStatus="status">
		<tr>
			<td><img src="" /></td>
			<td>${reply.id}</td>
			<td>${reply.content}</td>
			<td><a href="#">추천</a> <a href="#">반대</a></td>
			<td>${reply.strRegiDate}</td>
		</tr>
	</c:forEach>
	</table>
	<!--// 댓글 리스트 부분 끝 -->
</body>
</html>