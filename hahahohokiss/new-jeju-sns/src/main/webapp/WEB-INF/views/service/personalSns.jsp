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
	<div id="Title">
		<h1>개인 SNS</h1>
	</div>
	<div id="Header">
		<p>
			<label id="${loginUser.username}">${loginUser.username}( ${loginUser.explanation} )</label>
			<a href="/service/userform"><input type="button" value="프로필수정" /></a>
			<a href="javascript:window.open('/service/tweetWriteForm', 'tweet','width = 300px, height=200px')"><input type="button" value="글쓰기" /></a>
			<a href="/service/mainSns"><input type="button" value="메인페이지" /></a>
		</p>
	</div>
		
	<div id="PersonalListContent">
		<c:forEach items="${tweets}" var="tweet" >
			<table boarder="1">
				<tr>
					<td width="150" align="center">
						<img src = "${loginUser.imgUrl}" width="100" height="70"/>
					</td>
					<td width="250" align="center">
						<label>${tweet.contents}</label>
					</td>
					<td withd="150" align="center">
						<a href="/service/delete?tweetId=${tweet.tweetId }"><input type=button style="height: 35px; width: 90px"  value=삭제></a>
					</td>
					<td width="150" align="center">
						<label>${tweet.date}</label>
					</td>
					<td height="90">
					
					</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>