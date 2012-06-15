<%@page import="jnu.ce.bs.k.model.User"%>
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
	<div id="Header">
		<a href="jeju.bs">제주SNS</a>에 오신것을 환영합니다.
	</div>
	<div id="main">
		<fieldset>
			<p>
				<label><a href="myjeju.bs">
					<img src="resources/profile/${User.profile}" height="60px" width="60px"/>
					 &nbsp;&nbsp;&nbsp;&nbsp; ${User.name}(${User.description})</a></label>
				<input type="button" value="Follower" onclick="location.href='follower.bs'" class="button" /> 
				<input type="button" value="전체사용자" onclick="location.href='users.bs'" class="button" />
					 <input id="logout" type="button" value="Logout" onclick="location.href='logout'" class="button" />
			</p>
		</fieldset>
		<table>
			<thead>
				<tr>
					<th id="profile">profile</th>
					<th id="name">name</th>
					<th id="description">description</th>
					<th id="button">follow</th>
				</tr>
			</thead>
			<tbody>
 				<c:forEach items="${userList}" var="user">
					<tr>
						<td id="profile"><img src ="/resources/profile/${user.profile}" /></td>
						<td id="name"><a href="neighborhood.bs?id=${user.id}">${user.name}</a></td>
						<td id="description">${user.description}</td>
						<td id="button"><c:choose>
								<c:when test="${user.userNum == 'true'}">
									<form action="fwingunfollow" method="post">
										<input type="hidden" value="${user.id}" name="userId"></input>
										<input type="submit" value="Unfollow" class="innerbutton" ></input>
									</form>
								</c:when>
								<c:otherwise>
									<form action="fwingfollow" method="post">
										<input type="hidden" value="${user.id}" name="userId"></input>
										<input type="submit" value="follow" class="innerbutton" ></input>
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