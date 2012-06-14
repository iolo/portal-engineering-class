<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>육식토끼의 SNS</title>
</head>
<body>
	<div id="container">
	<div class="header">
		${loginUser.name }
		(${loginUser.introduce })
		<input type="button" value="글쓰기"	onclick="window.open('/userReg','NewWindow','width=400,height=380,toolbar=0,scrollbars=0,resizable=0');" />
		<input type="button" value="개인페이지" onclick="location.href='/?userid=${loginUser.userid }$password=${loginUser.password }'" />
		<input type="button" value="follower" onclick="location.href='/follower?userid=${loginUser.userid}'" />
		<input type="button" value="전체사용자" onclick="location.href='/alluser?userid=${loginuser.userid}'" />
		<input type="button" value="프로필수정" onclick="window.open('/modify','NewWindow','width=400,height=380,toolbar=0,scrollbars=0,resizable=0');" />
		<input type="button" value="로그아웃" onclick="location.href='/logout'" />
	</div>
	<hr/>
	<table>
		<c:forEach items="${user}" var="following">
				<img width=50px height=50px src="/resources/${following.image}" />
				${following.name }
				${following.introduce }
				<input type="button" value= "Unfollow" onclick="location.href='/unfollow?userid=${loginUser.userid }&followerid=${following.userid}&page=1'"/>
				<br/>
		</c:forEach>
	</table>
</div>
</body>
</html>