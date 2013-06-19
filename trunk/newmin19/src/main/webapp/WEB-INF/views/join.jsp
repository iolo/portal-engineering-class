<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원 가입</title>
</head>
<body>
	
	<form action="<c:url value="/joinProcess" />" method="post">
		<h1>회원가입</h1>
		<table>
			<tr><td>ID</td><td><input type="text" name="id" id="id" value="" /></td></tr>
			<tr><td>Password</td><td><input type="password" name="password" id="password" value="" /></td></tr>
			<tr><td>이름 </td><td><input type="text" name="name" id="name" value="" /></td></tr>
			<tr><td>설명 </td><td><input type="text" name="description" id="description" value="" /></td></tr>
			<tr><td>프로필이미지 </td><td><input type=file name='file1' > <onclick='document.all.file1.click();'></td></tr>
		</table>	
			
			<input type="submit" value="회원가입" />
			<input TYPE="button" VALUE="취소" onClick="history.back();">
	</form>
</body>
</html>