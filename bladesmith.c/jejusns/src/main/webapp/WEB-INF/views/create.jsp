<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 등록</title>
<link href="/resources/css/jeju.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="main">
		<form action="create" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>사용자 등록</legend>
				<p>
					<label>아이디</label>
					<input type="text" name="id" />
				</p>
				<p>
					<label>암호</label>
					<input type="password" name="password" />
				</p>
				<p>
					<label>이름</label>
					<input type="name" name="name" />
				</p>
				<p>
					<label>설명</label>
					<input type="text" name="description" />
				</p>
				<p>
					<label>프로필 이미지</label>
					<input type="file" name="profile" />
				</p>
				<p>
					<input type="submit" value="등록" /><input type="button" value="취소" onclick="self.history.go(-1)">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>