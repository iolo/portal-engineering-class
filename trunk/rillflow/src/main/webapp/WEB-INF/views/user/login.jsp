<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<div id="wrap">
	<h1>로그인</h1>
	<form action="<c:url value='/loginProcess'/>" method="post" name="loginForm" id="loginForm">
	   	<table>
	  		<tr>
	  			<th><label for="id">아이디</label></th>
	  			<td><input type="text" name="id" id="id" /></td>
	  		</tr>
	  		<tr>
	  			<th>비밀번호</th>
	  			<td><input type="password" name="password" id="password" /></td>
	  		</tr>
	  	</table>
		<input type="submit"  value="로그인" />
	</form>
</div>
</body>
</html>