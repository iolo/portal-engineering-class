<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<!-- 
	<link href="/user/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	-->
</head>
<body>
	<div id="Header">
		<img src="/twitter/resources/image/4.png"/>
		<p>
			<a href="/twitter/service/personalSNS"><label>${user.name}(${user.description })</label></a>
			<a href="/twitter/service/followingList"><input type="button" value="Following" /></a>
			<a href="/twitter/service/allUserList"><input type="button" value="전체사용자" /></a>
			<a href="/twitter/service/SNS"><input type="button" value="메인페이지" /></a>
			<a href="/twitter/logout"><input type="button" value="로그아웃" /></a>
		</p>
	</div>
		
	<div id="followerListContent">
		<c:forEach items="${followerList}" var="follow" >
			<table width="800" align="left">
				<tr> 
					<td width="100" align="center">
						<img src = "${follow.user.profileImg}"  width="80" height="80" />
					</td>
					<td width="100" align="left">${follow.user.name}</td>
					<td width="400"  align="left">${follow.user.description}</td>
					<td width="200"  align="center">
					<c:choose>
						<c:when test="${follow.state }">
							<a href="/twitter/service/unfollow?userNum=${follow.user.userNum}&url=/service/followerList">
								<input type="button" value="UnFollow" />
							</a>
						</c:when>
						<c:otherwise>
							<a href="/twitter/service/follow?userNum=${follow.user.userNum}&url=/service/followerList">
								<input type="button" value="Follow" />
							</a>
						</c:otherwise>
					</c:choose>
					</td>
				</tr>		
			</table>
		</c:forEach>
	</div>
</body>
</html>