<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
		<c:choose>
			<c:when test="${user=='guset'}">
				<button onclick="location.href='./join.write'">회원가입</button>
			</c:when>
			<c:when test="${user!='guset'}">
				<div>안녕하십니까? ${user}님</div>
			</c:when>
			<c:when test="${user == null}">
			
			</c:when>
		</c:choose>
		<button onclick="location.href='./write'">글쓰기</button>
	</div>
	<c:forEach items="${list}" var="comment">
		<div id="line">
			<span id="${comment.listId}">${comment.listId}</span> 
			<img style="width: 100px; height: 100px;" src="${comment.userUrl}"></img>
			<span
				id="userName">${comment.writer}</span> <span id="text">${comment.commentText}</span>
			<span id="btn">
				<button href="list?po=${comment.listId}">추천 :
					${comment.positive}</button>
				<button href="list?ne=${comment.listId}">반대 :
					${comment.negative}</button>
			</span>
		</div>
	</c:forEach>

	<c:forEach begin="1" end="${pageCount}" var="count">
		<button onclick="location.href='./list?page=${count}'">${count}</button>
	</c:forEach>
</body>
</html>