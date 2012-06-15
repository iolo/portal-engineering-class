<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>육식토끼의 SNS</title>
</head>
<body style="width:100%;">
	<div id="Header">
		<a style="display:inline-block; width:20%; text-align:center;">
			${loginUser.name }(${loginUser.introduce })
		</a>
		<input type="button" value="글쓰기"	onclick="window.open('/userReg','NewWindow','width=450,height=300,toolbar=0,scrollbars=0,resizable=0');" />
		<input type="button" value="개인페이지" onclick="location.href='/?userid=${loginUser.userid }$password=${loginUser.password }'" />
		<input type="button" value="following" onclick="location.href='/following?userid=${loginUser.userid}'" />
		<input type="button" value="전체사용자" onclick="location.href='/alluser?userid=${loginuser.userid}'" />
		<input type="button" value="프로필수정" onclick="window.open('/modify','NewWindow','width=400,height=380,toolbar=0,scrollbars=0,resizable=0');" />
		<input type="button" value="로그아웃" onclick="location.href='/logout'" />
		<hr/>
	</div>
	
	<div id="Content">
		<c:forEach items="${following}" var="follower">
				<span style="display:inline-block; width:5%; text-align:center;"><img width=50px height=50px src="/resources/${follower.image}" /></span>
				<span style="display:inline-block; width:10%; text-align:center;">${follower.name }</span>
				<span style="display:inline-block; width:20%; text-align:center;">${follower.introduce }</span>				
				<c:if test="${follower.follow == 'UnFollow' }">
					<span style="display:inline-block; width:5%; text-align:center;"><input type="button" value = "${follower.follow }" onclick="location.href='/unfollow?userid=${loginUser.userid }&followerid=${follower.userid}&page=2'" /></span>
				</c:if>
				<c:if test="${follower.follow == 'Follow' }">
					<span style="display:inline-block; width:5%; text-align:center;"><input type="button" value = "${follower.follow }" onclick="location.href='/unfollow?userid=${loginUser.userid }&followerid=${follower.userid}&page=3'" /></span>
				</c:if>				
				<br/>
				<hr/>
		</c:forEach>
	</div>
</body>
</html>