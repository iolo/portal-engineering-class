<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Follow 페이지</title>
</head>
<body>
	<div id="Title">
		<h1>Follower</h1>
	</div>
	<div id="Header">
		<p>
			<label id="${loginUser.username}">${loginUser.username}( ${loginUser.explanation} )</label>
			<a href="javascript:window.open('/service/tweetWriteForm', 'test','width=300, height=70')"><input type="button" value="글쓰기" /></a>
			<a href="/service/followingList"><input type="button" value="Following" /></a>
			<a href="/service/followerList"><input type="button" value="Follower" /></a>
			<a href="/service/allUserList"><input type="button" value="전체사용자" /></a>
			<a href="/service/personalSns"><input type="button" value="개인 페이지" /></a>
			<a href="/service/mainSns"><input type="button" value="메인페이지" /></a>
		</p>
	</div>
		
	<div id="AllUserListContent">
		<c:forEach items="${userDtos}" var="userDto" >
			<table boarder="1">
				<tr>
					<td width="100">
						<img src= "${userDto.user.imgUrl}" width="100" height="70" />
					</td>
					<td width="200">
						<label>${userDto.user.username}</label>
					</td>
					<td width="150">
						<label>${userDto.user.explanation}</label>
					</td>
					<td withd="100">
						<c:choose>
							<c:when test="${userDto.follow}">
								<a href="/service/unfollow?followingId=${userDto.user.loginId }"><input type=button style="height: 35px; width: 90px" value="Unfollow"></a>
							</c:when> <c:otherwise>
								<a href="/service/follow?followingId=${userDto.user.loginId }"><input type=button style="height: 35px; width: 90px" value="Follow"></a>
							</c:otherwise>
						</c:choose>
					</td>
					<td height="90">
					
					</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>