<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/common.css'/>" type="text/css" rel="stylesheet" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>댓글 등록</title>
</head>
<body>
<div id="wrap">
	<form name="replyForm" id="replyForm" action="<c:url value='/writeProcess'/>" method="post" onsubmit="login();">
	<div id="writeForm">
		<h2>댓글 등록</h2>
		<textarea rows="3" name="content"></textarea>
		<div id="btnList">
			<input type="submit" value="글쓰기" />
			<button type="button"  onclick="location.href=<c:url value='/' />">취소</button>
		</div>
	</div>
	</form>
</div>
</body>
</html>