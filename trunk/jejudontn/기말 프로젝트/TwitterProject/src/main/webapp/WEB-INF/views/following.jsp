<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 등록</title>
	<link href="/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div>
		Following
	</div>
	<div>
<p>
		<input type="button" value="${user.name}"
							onclick="location.href='/personal'"; />
		<input type="button" value="글쓰기"
		onclick="window.open('/write','win','width=400,height=480,toolbar=0,scrollbars=0,resizable=0')"; />
		<input type="button" value="Following"
							onclick="location.href='/following'"; />
		<input type="button" value="Follower"
							onclick="location.href='/follower'"; />
		<input type="button" value="전체사용자"
							onclick="location.href='/alluser'"; />
	</p>
	</div>
	
	<div>
		<table>
			<caption>following</caption>
			<thead>
				<tr>
					<th>사용자</th>
					<th>이름</th>
					<th>정보</th>
					<th>follower</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${followingUserList}" var="user" >
				<tr>
					<td>${user.profilImage} </td>
					<td>${user.name} </td>
					<td>${user.information} </td>
					<td><a href="remove?id=${user.id}">${followFlag}</a></td>
				</tr>
			</c:forEach>
			</tbody>	
		</table>
	</div>
</body>
</html>