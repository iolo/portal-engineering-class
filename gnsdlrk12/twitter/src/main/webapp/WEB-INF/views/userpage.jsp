<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인 페이지</title>



</head>
<body>
	<div id="Header">
		${user.name }
		(${user.introduce })
		<input type="button" value="글쓰기"	onclick="window.open('/write','NewWindow','width=400,height=380,toolbar=0,scrollbars=0,resizable=0');" />
		<input type="button" value="회원수정" />
		<input type="button" value="로그아웃" onclick="location.href='/logout'" />
	</div>
	<div id="Content">
		<c:forEach items="${posts}" var="post">
			<input type="hidden" value="${post.post_num}" name="post_num"/>			
			<input type="hidden" value="${post.postid}" name="postid"/>
			<img width=50px height=50px src="/resources/${post.image }"/>			
			${post.content }
			<%-- <td><a href="personal/remove?twittId=${twitt.twiitNumber}">삭제</a></td> --%>
			<input type="button" value="삭제" onclick="location.href='/delete?postid=${post.postid }&post_num=${post.post_num}'" />
			${post.regdate }
			<br/>
		</c:forEach>
	</div>
	
</body>
</html>