<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<title>Comment List</title>
	<style type="text/css">
		
	</style>
</head>

<h1>댓글 작성</h1>
<form name="commentWriteForm" action="<c:url value='/writeprocess'/>" method="post">
	<textarea name="comment"></textarea>
	<input type="hidden" name="userName" value="${user.userName}">
	<input type="submit" value="글쓰기" />
	<button>취소</button>
</form>

</body>
</html>
