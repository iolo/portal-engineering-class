<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 등록</title>
<link href="resources/menu.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="Header">사용자 관리</div>
	<div id="Menu">
		<input type="button" value="프로필수정" onclick=""><br>
		<input type="button" value="글쓰기" onclick="">
	</div>
	<div id="Content">
		<form action="list" method="post">
			<table>
				<caption>사용자 목록</caption>
				<thead>
					<tr>
						<th>이미지</th>
						<th>내용</th>
						<th>기간</th>
						<th>기타</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.image}</td>
							<td>${user.memo}</td>
							<td><a href="remove?id=${user.id }">삭제</a></td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>