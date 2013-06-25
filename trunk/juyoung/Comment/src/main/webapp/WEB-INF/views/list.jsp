<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<button onclick="location.href='login.out'">로그아웃</button>
			</c:when>
			<c:when test="${user == null}">
			
			</c:when>
		</c:choose>
		<button onclick="location.href='./write'">글쓰기</button>
	</div>
	<c:forEach items="${list}" var="comment">
		<div id="line">
			<span id="${comment.listId}">${comment.listId}</span> 
			<img style="width: 100px; height: 100px;" src="${comment.userUrl}" />
			<span
				id="userName">${comment.writer}</span> <span id="text">${comment.commentText}</span>
			<span id="btn">
				<button onclick="location.href='like?it=${comment.listId}&like=po'">추천 :${comment.positive} </button>
				<button onclick="location.href='like?it=${comment.listId}&like=ne'">반대 :${comment.negative} </button>
			</span>
			<c:if test="${userName == comment.writer}">
				<button onclick="location.href='detele?it=${comment.listId}'">삭제</button>
			</c:if>
		</div>
	</c:forEach>

	<c:forEach begin="1" end="${pageCount}" var="count">
		<button onclick="location.href='./list?page=${count}'">${count}</button>
	</c:forEach>
</body>
</html>