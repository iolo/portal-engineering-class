<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>join</title>
</head>
<body>
<div>
	<form name="joinUserInfo" action="./join.save" method="post" enctype="multipart/form-data">
		id : <input type="text" name="id"><br />
		password : <input type="password" name="password"><br />
		이름 : <input type="text" name="name"><br />
		설명 : <input type="text" name="proflie"><br />
		프로필 이미지 : <input type="file" name="file"><br />
		<input type="submit" value="회원가입" />
		<button onclick="location.href='http://localhost:8080/jejunu/list'">취소</button>
	</form>
	
	
</div>

</body>
</html>