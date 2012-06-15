<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 수정</title>
<link href="/resources/css/write.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="main">
		<form action="modify" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>사용자 수정</legend>
				<p>
					<label>아이디</label>
					<input type="text" name="id" value="${User.id}" readonly="readonly" class="input" />
				</p>
				<p>
					<label>암호</label>
					<input type="password" name="modifypassword" class="input" />
				</p>
				<p>
					<label>이름</label>
					<input type="name" name="modifyname" class="input" />
				</p>
				<p>
					<label>설명</label>
					<input type="text" name="modifydescription" class="input" />
				</p>
				<p>
					<label>프로필 이미지</label>
					<input type="file" name="modifyprofile" class="input" />
				</p>
				<div id="button_gap">
				<p>
					<input type="submit" value="수정" class="button" />
					<input type="button" value="취소" onclick="self.history.go(-1)" class="button" />
				</p>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>