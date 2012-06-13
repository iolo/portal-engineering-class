<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
<link href="resources/menu.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<center>
		<h1>JEJU SNS</h1>
	</center>
		
	<div id="Content">
		<form action="login" method="post">
			<table>
				<tr>
					<td><label>아이디</label></td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td><label>암호</label></td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
				<input type="submit" value="로그인" />				
				<input type="button" value="회원가입" onclick="location.href='/create'" />
		</form>
	</div>
</body>
</html>