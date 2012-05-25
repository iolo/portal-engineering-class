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
		개인 트윗 관리
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
			<caption>SNS MAIN</caption>
			<thead>
				<tr>
					<th>사용자</th>
					<th>이름</th>
					<th>트윗</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${twittList}" var="twittList" >
				<tr>
					<td>${twittList.profilImage} </td>
					<td>${twittList.name} </td>
					<td>${twittList.twitt}</td>
					<td>${twittList.date} </td>
				</tr>
			</c:forEach>
			</tbody>	
		</table>
	</div>
</body>
</html>