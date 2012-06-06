<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JejuSNS 가입</title>
</head>
<body>
	<form action="join.submit">
		이름 : <input type="text" name="name" placeholder="최대 20자 이내"/><br>
		ID : <input type="text" name="id" placeholder="최대 20자 이내"/><br>
		비밀번호 : <input type="password" name="password" placeholder="최대 38자 이내"/><br>
		자기소개 : <input type="text" name="comment"/><br>
		<input type="submit" value="JOIN"/>
	</form>
</body>
</html>