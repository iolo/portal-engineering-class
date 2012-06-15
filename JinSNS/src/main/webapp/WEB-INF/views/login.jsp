<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<h2>제주 SNS에 오신것을 환영합니다.</h2>
	</div>
	<div> 
	<form action="login" method="post">
	<table>
 		<tr>
			<td><label>ID</label></td>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td><label>Password</label></td>
			<td><input type="password" name="password" /><td>
		</tr>
	</table>
				<input type="submit" value="로그인" />				
				<input type="button" value="회원가입" onclick="location.href='/join'" />
				
	 </form>
	</div>
	
</body>
</html>