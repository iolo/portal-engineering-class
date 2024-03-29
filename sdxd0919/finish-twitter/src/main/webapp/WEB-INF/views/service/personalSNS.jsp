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
		<img src="/twitter/resources/image/2.png"/>
		<p>
			<a href="/twitter/service/personalSNS"><label>${user.name}(${user.description })</label></a>
			<a href="/twitter/service/profile"><input type="button" value="프로필수정" /></a>
			<a href="javascript:void(window.open('/twitter/service/write', '글쓰기',
						'width=400, height=200'))"><input type="button" value="글쓰기" /></a>
			<a href="/twitter/service/SNS"><input type="button" value="메인페이지" /></a>
			<a href="/twitter/logout"><input type="button" value="로그아웃" /></a>
		</p>
	</div>
	
	<div id="PersonalListContent">
			<c:forEach items="${tweetList}" var="tweets" >
			<table width="800" align="left">
				<tr>
					<td width="100" align="center">
	 					<img src = "${user.profileImg}"  width="80" height="80" />
	 				</td>
	 				<td width="400"  align="left">
						<label>${tweets.message}</label>
					</td>
					<td width="100"  align="center">
						<a href="/twitter/service/deleteTweet?seq=${tweets.seq}">
							<input type="button" value="삭제" />
						</a>
					</td>
					<td width="200"  align="center">
						<label>${tweets.date}</label>
					</td>
				</tr>
			</table>
			</c:forEach>
	</div>
</body>
</html>