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
		<input type="button" value="follower" onclick="location.href='/follower?userid=${loginUser.userid}'" />
		<input type="button" value="전체사용자" onclick="location.href='/alluser?userid=${loginuser.userid}'" />
		<input type="button" value="프로필수정" onclick="window.open('/modify','NewWindow','width=400,height=380,toolbar=0,scrollbars=0,resizable=0');" />
		<input type="button" value="로그아웃" onclick="location.href='/logout'" />
		<hr/>
	</div>	
	<div id="Content">
		<c:forEach items="${user}" var="following">
				<span style="display:inline-block; width:5%; text-align:center;"><img width=50px height=50px src="/resources/${following.image}" /></span>
				<span style="display:inline-block; width:10%; text-align:center;">${following.name }</span>
				<span style="display:inline-block; width:20%; text-align:center;">${following.introduce }</span>
				<span style="display:inline-block; width:5%; text-align:center;"><input type="button" value= "Unfollow" onclick="location.href='/unfollow?userid=${loginUser.userid }&followerid=${following.userid}&page=1'"/></span>
				<br/>
				<hr/>
		</c:forEach>
	</div>	
</body>
</html>