<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 등록</title>
<link href="/user/resources/jeju.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="Header">제주SNS에 오신것을 환영합니다.</div>
	<div id="main">
		<fieldset>
			<p>
				<label>${User.name}(${User.description})</label> 
				<input type="button" value="글쓰기" onclick="window.open('write.bs')" />
				<input type="button" value="Following" onclick=""> 
				<input type="button" value="Follower" onclick=""> 
				<input type="button" value="전체사용자" onclick="location.href()">
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