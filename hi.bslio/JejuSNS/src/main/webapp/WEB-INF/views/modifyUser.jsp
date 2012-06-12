<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="userModify" enctype="multipart/form-data">
		ID : ${User.id}<br>
		이름 : <input type="text" name="name" placeholder="최대 20자 이내" value="${User.name}"/><br>		
		비밀번호 : <input type="password" name="password" placeholder="최대 38자 이내" value="${User.password}"/><br>
		자기소개 : <input type="text" name="comment" value="${User.comment}"/><br>
		<img src="/images/userprofile/${User.image}" width=48 height=48><input type="file" name="file"/>
		<input type="submit" value="수정"/>
	</form>
</body>
</html>