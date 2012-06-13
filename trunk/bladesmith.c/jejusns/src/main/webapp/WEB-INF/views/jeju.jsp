<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jejuSNS</title>
<link href="/user/resources/jeju.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="Header"><a href="jeju.bs">제주SNS</a>에 오신것을 환영합니다.</div>
	<div id="main">
		<fieldset>
			<p>
				<label><a href="myjeju.bs">${User.name}(${User.description})</a></label>
				<input type="button" value="글쓰기" onclick="window.open('write.bs')" />
				<input type="button" value="Following" onclick="location.href='following.bs'">
				<input type="button" value="Follower" onclick=""> 
				<input type="button" value="전체사용자" onclick="location.href='users.bs'">
			</p>
		</fieldset>
		<table>
			<thead>
				<tr>
					<th>profile</th>
					<th>writer</th>
					<th>note</th>
					<th>date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notesList}" var="note">
					<tr>
						<td>${notes.writer}</td>
						<td>${notes.writer}</td>
						<td>${notes.note}</td>
						<td>${notes.write_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>