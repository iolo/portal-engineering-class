<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jejuSNS</title>
<link href="/resources/css/jeju.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="Header"><a href="jeju.bs">제주SNS</a>에 오신것을 환영합니다.</div>
	<div id="main">
		<fieldset>
			<p>
				<label><a href="myjeju.bs">
					<img src="resources/profile/${User.profile}" height="60px" width="60px"/>
					 &nbsp;&nbsp;&nbsp;&nbsp; ${User.name}(${User.description})</a></label>
				<input type="button" value="프로필 수정" onclick="location.href='modify.bs'" class="button" />
				<input type="button" value="글쓰기" onclick="window.open('write.bs')" class="button" />
				<input id="logout" type="button" value="Logout" onclick="location.href='logout'" class="button" />
			</p>
		</fieldset>
		<table>
			<thead>
				<tr>
					<th id="profile">profile</th>
					<th id="note">note</th>
					<th id="button">check</th>
					<th id="date">date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${noteList}" var="note">
					<tr>
						<td id="profile"><img src ="/resources/profile/${User.profile}" /></td>
						<td id="note">${note.note}</td>
						<td id="button">
						<button id="delete" value="delete" type="button" onclick="location.href='remove?write_num=${note.write_num}'" class="innerbutton" >삭제</button></td>
						<td id="date">${note.write_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>