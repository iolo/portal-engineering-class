<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>개인 SNS</title>
	<!-- 
	<link href="/user/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	-->
</head>
<body>
	<div id="Header">
		<p>
			<label>${user.name}</label>
			<a href="/twitter/join"><input type="button" value="프로필수정" /></a>
			<a href="javascript:void(window.open('/twitter/write', '글쓰기',
						'width=500, height=300'))"><input type="button" value="글쓰기" /></a>
			<a href="/twitter/sns"><input type="button" value="메인페이지" /></a>
		</p>
	</div>
	
	<div id="PersonalListContent">
		<table>
			<c:forEach items="${tweetList}" var="tweets" >
				<tr>
					<td>
	 					<img src = "${usery.profileImg}" />
	 				</td>
	 				<td>
						<label>${tweets.message}</label>
					</td>
					<td>
						<a href="/twitter/deleteTweet?seq=${tweets.seq}">
							<input type="button" value="삭제" />
						</a>
					</td>
					<td>
						<label>${tweets.date}</label>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>