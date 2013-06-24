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
	</style>
</head>

<h1>댓글리스트(로그인 안됨)</h1>
<a href="./join">회원가입</a><a href="./write">글쓰기</a>
<table id="commentList">
	<c:forEach items="${commentList}" var="comment" varStatus="status">
		<tr>
			<td class="profileImage"><img src="" alt="프로필 사진"/></td>
			<td class="userName">${comment.userName}</td>
			<td class="commentContent">${comment.comment}</td>
			<td class="commentRecommend"><button>추천</button><button>반대</button></td>
			<td class="commentRegDate">${comment.regdateToString}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
