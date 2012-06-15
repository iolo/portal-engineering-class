<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인 페이지</title>
</head>
<body style="width:100%;">
	<div id="Header">
		<a style="display:inline-block; width:20%; text-align:center;">
			${user.name }(${user.introduce })
		</a>
			<input type="button" value="글쓰기"	onclick="window.open('/userReg','NewWindow','width=450,height=300,toolbar=0,scrollbars=0,resizable=0');" />
			<input type="button" value="following" onclick="location.href='/following?userid=${user.userid}'" />
			<input type="button" value="follower" onclick="location.href='/follower?userid=${user.userid}'" />
			<input type="button" value="전체사용자" onclick="location.href='/alluser?userid=${user.userid}'" />
			<input type="button" value="프로필수정" onclick="window.open('/modify','NewWindow','width=400,height=380,toolbar=0,scrollbars=0,resizable=0');" />
			<input type="button" value="로그아웃" onclick="location.href='/logout'" />		
		<hr/>		
	</div>	
	<div id="Content">
		<c:forEach items="${posts}" var="post">
			<input type="hidden" value="${post.post_num}" name="post_num"/>
			<input type="hidden" value="${post.postid}" name="postid"/>
			<span style="display:inline-block; width:5%; text-align:center;"><img width=50px height=50px align="middle" src="/resources/${post.image }"/></span>	
			<span style="display:inline-block; width:20%; text-align:center;">${post.content }</span>
			<span style="display:inline-block; width:5%; text-align:center;"><input type="button" value="삭제" onclick="location.href='/delete?postid=${post.postid }&post_num=${post.post_num}'" /></span>
			<span style="display:inline-block; width:250px; text-align:center;">${post.regdate }</span>
		<br />
		<hr/>
		</c:forEach>
	</div>	
</body>
</html>