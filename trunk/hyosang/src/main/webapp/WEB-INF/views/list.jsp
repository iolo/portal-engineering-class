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

<h1>댓글리스트</h1>
<table id="commentList">
	<c:forEach items="${commentList}" var="comment" varStatus="status">
		<tr>
			<td class="commentNumber">${comment.id}</td>
			<td class="profileImage"><img src="" alt="프로필 사진"/></td>
			<td class="commentContent">${comment.comment}</td>
			<td class="commentRecommend"><button>추천</button><button>반대</button></td>
			<td class="commentRegDate">${comment.regdate}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
