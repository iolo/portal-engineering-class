<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Following 페이지</title>
</head>
<body>
	<div id="Header">
		<p>
			<label id="${loginUser.username}">${loginUser.username}( ${loginUser.explanation} )</label>
			<a href="/service/userform"><input type="button" value="프로필수정" /></a>
			<a href="/service/mainSns"><input type="button" value="메인페이지" /></a>
		</p>
	</div>
		
	<div id="AllUserListContent">
		<c:forEach items="${users}" var="user" >
			<table boarder="1">
				<tr>
					<td width="100">
						<img src= "${user.imgUrl}" width="100" height="70" />
					</td>
					<td width="200">
						<label>${user.username}</label>
					</td>
					<td width="150">
						<label>${user.explanation}</label>
					</td>
					<td withd="100">
						<a href="/service/unfollow?followingId=${user.loginId }"><input type=button style="height: 35px; width: 90px" value="Unfollow"></a>
					</td>
					<td height="90">
					
					</td>
				</tr>
			</table>
 				<%-- <img src = "${loginUser.imgUrl}" width="100" height="70"	/>
				<label>${tweet.contents}</label>
				<a href="/service/delete?tweetId=${tweet.tweetId }">삭제</a>
				<label>${tweet.date}</label><p> --%>
		</c:forEach>
	</div>
</body>
</html>