<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>    
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list</title>
</head>
<body>
	<div id="login">
		<button onclick="location.href='./write'">글쓰기</button>
	</div>
	<c:forEach items="${list}" var="comment" >
	<div id="line">
		<div id="${comment.listId}">${comment.listId}</div>
		<div id="userName">${comment.writer}</div>
		<div id="text">${comment.commentText}</div>
		<div id="btn">
			<button href="like?po=${comment.listId}">추천 : ${comment.positive}</button>
			<button href="like?ne=${comment.listId}">반대 : ${comment.negative}</button>
		</div>
	</div>
	</c:forEach>

</body>
</html>