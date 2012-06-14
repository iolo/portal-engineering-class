<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<h2>회원 가입</h2>
	</div>
	<div> 
	<form action="join" method="post" enctype="multipart/form-data">
	<table>
 		<tr>
			<td><label>ID</label></td>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td><label>Password</label></td>
			<td><input type="password" name="password" /><td>
		</tr>
		<tr>
			<td><label>PasswordCheck</label></td>
			<td><input type="password" name="passwordcheck" /><td>
		</tr>
		<tr>
			<td><label>이 름</label></td>
			<td><input type="text" name="name" /><td>
		</tr>
		<tr>
			<td><label>설 명</label></td>
			<td><input type="text" name="explain" /><td>
		</tr>
		<tr>
			<td><label>프로필 이미지</label></td>
			<td><input type="file" name="image" /><td>
		</tr>
		<tr><td><center>
				<input type="submit" value="회원가입" />				
				<input type="button" value="취소" onclick="location.href='/login'"/>
		</center></td></tr>
	</table>
	 </form>
	</div>
	
</body>
</html>