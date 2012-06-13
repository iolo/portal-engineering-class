<%@page import="jnu.ce.bs.k.model.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jejuSNS</title>
<link href="/user/resources/jeju.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="Header">
		<a href="jeju.bs">제주SNS</a>에 오신것을 환영합니다.
	</div>
	<div id="main">
		<fieldset>
			<p>
				<label><a href="myjeju.bs">${User.name}(${User.description})</a></label>
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
						<td><c:choose>
								<c:when test="${user.userNum == 'true'}">
									<form action="unfollow" method="post">
										<input type="hidden" value="${user.id}" name="userId"></input>
										<input type="submit" value="unFollow"></input>
									</form>
								</c:when>
								<c:otherwise>
									<form action="follow" method="post">
										<input type="hidden" value="${user.id}" name="userId"></input>
										<input type="submit" value="follow"></input>
									</form>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>