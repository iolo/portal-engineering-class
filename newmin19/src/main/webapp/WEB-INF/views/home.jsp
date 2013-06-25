<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
	body{text-align: center;}
	table {margin:0 auto;}
</style>
</head>
<body>

	<c:choose>
		<c:when test="${not empty sessionScope.userLoginInfo}">
			<!--로그인-->
			<h1>댓글 시스템(로그인 상태)</h1>
			${sessionScope.userLoginInfo.name} (${sessionScope.userLoginInfo.description})
			<a href="<c:url value='modify'/>">프로필수정</a>
			<a href="<c:url value='logout'/>">로그아웃</a>
			<a href="<c:url value='writeComment'/>">글쓰기</a>
		</c:when>
		<c:otherwise>
			<!--로그인 안됬을 때 -->
			<h1>댓글 시스템(비로그인 상태)</h1>
			<a href="<c:url value='join'/>">회원가입</a>
			<a href="<c:url value='login'/>">글쓰기</a>
		</c:otherwise>
	</c:choose>

	<br><br><br>
	<table border="1" cellspacing =0>
		<c:forEach var="result" items="${comments}" varStatus="status">
			<tr>
				<td><image src="resources/MG.jpg" width="45"/></td>
				<td><c:out value="${result.name}" /></td>
				<td><c:out value="${result.comment}" /></td>
				<td><div class="form-actions">
						<button type="button" class="btn">추천</button>
						<button type="button" class="btn">반대</button>
					</div></td>
				<td><c:out value="${result.strRegdate}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
