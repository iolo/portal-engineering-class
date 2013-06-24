<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<title>댓글리스트</title>
	<style type="text/css">
		body{text-align: center;}
		table{margin: 0 auto;}
		td{border: solid 1px; height: 50px; padding: 10px;}
		.profileImage{width: 50px;}
		.commentContent{width: 250px;}
	</style>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.css'/>" />
	
</head>

<h1>댓글리스트(로그인 안됨)</h1>
<a class="btn btn-primary" href="./join">회원가입</a> <a class="btn" href="./write">글쓰기</a><br /><br />
<table id="commentList">
	<c:forEach items="${commentList}" var="comment" varStatus="status">
		<tr>
			<td class="profileImage"><img src="" alt="프로필 사진"/></td>
			<td class="userName">${comment.userName}</td>
			<td class="commentContent">${comment.comment}</td>
			<td class="commentRecommend"><a class="btn" href="">추천[0]</a></td>
			<td class="commentRegDate">${comment.regdateToString}</td>
		</tr>
	</c:forEach>
</table>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>
