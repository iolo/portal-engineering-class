<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글 시스템</title>
<link href="<c:url value='/resources/css/common.css'/>" type="text/css" rel="stylesheet" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
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

function popup(duple) {
	if(duple == '1') {
		alert("이미 추천을 하셨습니다.");	
	}
	if(duple == '2') {
		alert("이미 반대를 하셨습니다.");	
	}
}
</script>
</head>
<body onload="popup(${duple})">
	<div id="wrap">
		<h2>댓글 시스템</h2>
		<!-- 회원정보, 메뉴버튼 부분 시작 -->
		<c:choose>
			<c:when test="${not empty sessionScope.user}">
				<!-- 로그인 상태 -->
				<p class="profile"><strong>${sessionScope.user.name}님</strong> (${sessionScope.user.description})</p>
				<div id="btnList">
					<a href="<c:url value='/user/modify'/>" class="btn">프로필수정</a>
					<a href="<c:url value='/write'/>" class="btn">글쓰기</a>
					<a href="<c:url value='/logout'/>" class="btn">로그아웃</a>
				</div>
			</c:when>
			<c:otherwise>
				<!-- 비로그인 상태 -->
				<div id="btnList">
					<a href="<c:url value='/user/join'/>" class="btn">회원가입</a>
					<a href="<c:url value='/write'/>" class="btn">글쓰기</a>
				</div>
			</c:otherwise>
		</c:choose>
		<!--// 회원정보, 메뉴버튼 부분 끝 -->
		<!-- 댓글 리스트 부분 시작 -->
		<div id="replyList">
			<c:forEach items="${replyList}" var="reply" varStatus="status">
				<div class="reply">
					<img src="<c:url value='/resources/profile/${reply.profPath}'/>" />
					<dl>
						<dt>
							<span class="userName">${reply.name}</span><span class="userId">(${reply.id})</span>
							<span class="date">| ${reply.strRegiDate}</span> 
						</dt>
						<dd class="content">${reply.content}</dd>
						<dd class="rating">
							<c:choose>
								<c:when test="${not empty sessionScope.user}">
									<!-- 로그인 상태 -->
									<a href="<c:url value='/upRating'/>?replyNo=${reply.replyNo}" class="up">추천(${reply.upCount})</a> 
									<a href="<c:url value='/downRating'/>?replyNo=${reply.replyNo}" class="down">반대(${reply.downCount})</a>
								</c:when>
								<c:otherwise>
									<!-- 비로그인 상태 -->
									<a href="<c:url value='/login'/>" class="up">추천(${reply.upCount})</a> 
									<a href="<c:url value='/login'/>" class="down">반대(${reply.downCount})</a>
								</c:otherwise>
							</c:choose>
							</dd>
					</dl>
				</div>
			</c:forEach>
		</div>
	<!--// 댓글 리스트 부분 끝 -->
	</div>
</body>
</html>