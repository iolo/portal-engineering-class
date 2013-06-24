<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<title>Comment List</title>
	<style type="text/css">
		td{border: solid 1px; height: 50px;}
		.commentNumber{}
		.profileImage{width: 50px;}
		.commentContent{width: 250px;}
		.commentRecommend{}
		.commentRegDate{}
		.userInfo{font-weight: bold;}
	</style>
</head>

<h1>댓글리스트(로그인 됨)</h1>
<span class="userInfo">${user.userName}(${user.userInfo})</span> <a href="./modify">프로필 수정</a> <a href="./write">글쓰기</a>
<table id="commentList">
	<c:forEach items="${commentList}" var="comment" varStatus="status">
		<tr>
			<td class="profileImage"><img src="" alt="프로필 사진"/></td>
			<td class="userName">${comment.userName}</td>
			<td class="commentContent">${comment.comment}</td>
			<td class="commentRecommend"><button>추천</button><button>반대</button></td>
			<c:choose>
				<c:when test="${comment.userId==user.userId}">
					<td class="commentDelete"><a href="./delete?id=${comment.id}">삭제</a></td>
				</c:when>
				<c:otherwise>
					<td class="commentDelete"></td>
				</c:otherwise>
			</c:choose>
			<td class="commentRegDate">${comment.regdateToString}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
