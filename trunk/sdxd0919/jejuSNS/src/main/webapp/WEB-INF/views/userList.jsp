<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<!-- 
	<link href="/user/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	-->
</head>
<body>
	<div id="Header">
		<p>
			<label id="${userName}"></label>
		</p>
	</div>
		
	<div id="UserListContent"> 
		<c:forEach items="${userLists}" var="user" >
			<div>
				<p>
					<img src = "${profileImg}" />
					<label>${name}</label>
					<label>${description}</label>
					
					<!-- 여기가 어렵다아…..ㅠㅠㅠㅠㅠ 어떻게 하지!!!!!????? [수정할 것!!!!]
					<c:forEach items="${followLists}" var="follower" >
						<c:if flag = {user == follower} >
							<a href="/follow"><input type="button" value="Follow" /></a></a>					
					</c:if>
					
					<c:if flag={ flag == null }>					
						<a href="/unfollow"><input type="button" value="UnFollow" /></a>					
					 -->
				</p>		
			</div>
		</c:forEach>
	</div>
</body>
</html>