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
	var popup = window.open(
		"<c:url value='/write'/>",
		"글쓰기",
		"menubar=no,width=400,height=170,toolbar=no"
	);
	
	popup.onunload = refreshParent;
}

function refreshParent() {
    window.location.reload();
}
</script>
</head>
<body>
	<!-- 회원정보, 메뉴버튼 부분 시작 -->
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
			<!-- 로그인 상태 -->
			${sessionScope.user.name} (${sessionScope.user.description})
			<a href="<c:url value='/user/modify'/>">프로필수정</a>
			<a href="<c:url value='/logout'/>">로그아웃</a>
		</c:when>
		<c:otherwise>
			<!-- 비로그인 상태 -->
			<a href="<c:url value='/user/join'/>">회원가입</a>
		</c:otherwise>
	</c:choose>
	<a href="#WRITE" onclick="writePopup();">글쓰기</a>
	<!--// 회원정보, 메뉴버튼 부분 끝 -->
	<hr>
	<!-- 댓글 리스트 부분 시작 -->
	<table>		 
	<c:forEach items="${replyList}" var="reply" varStatus="status">
		<tr>
			<td><img src="<c:url value='/resources/profile/${reply.profPath}'/>" style="width:40px;"/></td>
			<td>${reply.name}(${reply.id})</td>
			<td>${reply.content}</td>
			<td><a href="#">추천(${reply.upCount})</a> <a href="#">반대(${reply.downCount})</a></td>
			<td>${reply.strRegiDate}</td>
		</tr>
	</c:forEach>
	</table>
	<!--// 댓글 리스트 부분 끝 -->
</body>
</html>