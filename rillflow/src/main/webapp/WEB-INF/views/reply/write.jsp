<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
<div id="wrap">
<form action="<c:url value='/writeProcess'/>" method="post" name="replyForm" id="replyForm">
	<h1>댓글 등록</h1>
	<textarea rows="5" name="content"></textarea>
	<input type="submit" value="저장" />
	<button type="button" onclick="location.href=<c:url value='/' />">취소</button>
</form>
</div>
</body>
</html>