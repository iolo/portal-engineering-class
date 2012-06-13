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

	<div class = "menu">
	<p>
		<input type="button" value="${user.name}"
							onclick="location.href='/personal'"; />
		<input type="button" value="프로필 수정"
							onclick="location.href='/modify'"; />
		<input type="button" value="글쓰기"
		onclick="window.open('/write','win','width=400,height=380,toolbar=0,scrollbars=0,resizable=0')" ; />
		<input type="button" value="메인화면" onclick="location.href='/main'" ; />
	</p>
	</div>
	
	<div class = "show">
		<table>
			<caption>내 글</caption>
			<thead>
				<tr>
					<th>사용자</th>
					<th>트윗</th>
					<th>삭제</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${twittListList}" var="twitt" >
				<tr>
					<td><img src ="/resources/ProfileImage/${user.imageURI}"/> </td>
					<td>${twitt.twiitText} </td>
					<td><a href="personal/remove?twittId=${twitt.twiitNumber}">삭제</a></td>
					<td>${twitt.writeDate} </td>
				</tr>
			</c:forEach>
			</tbody>	
		</table>
	</div>
</body>
</html>