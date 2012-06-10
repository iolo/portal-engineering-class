<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>개인 SNS</title>
</head>
<body>
	<div id="Header">
		<p>
			<label id="${loginUser.username}">${loginUser.username}( ${loginUser.explanation} )</label>
			<a href="javascript:window.open('/service/tweetWriteForm', 'test','width=300, height=70')"><input type="button" value="글쓰기" /></a>
			<a href="/service/followingList"><input type="button" value="Following" /></a>
			<a href="/service/followerList"><input type="button" value="Follower" /></a>
			<a href="/service/allUserList"><input type="button" value="전체사용자" /></a>
			<a href="/service/personalSns"><input type="button" value="개인 페이지" /></a>
		</p>
	</div>
		
	<div id="PersonalListContent">
		<c:forEach items="${tweets}" var="tweet" >
			<table boarder="1">
				<tr>
					<td width="100">
						<img src = "${loginUser.imgUrl}" width="100" height="70"/>
					</td>
					<td width="200">
						<label>${tweet.user.loginId}</label>
					</td>
					<td width="200">
						<label>${tweet.contents}</label>
					</td>
				
					<td width="150">
						<label>${tweet.date}</label>
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