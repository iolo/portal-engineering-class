<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
			</p>
		</fieldset>
		<table>
			<thead>
				<tr>
					<th>profile</th>
					<th>name</th>
					<th>description</th>
					<th>follow</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.profile}</td>
						<td>${user.name}</td>
						<td>${user.description}</td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>