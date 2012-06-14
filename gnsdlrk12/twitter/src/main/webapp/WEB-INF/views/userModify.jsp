<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>프로필 수정</title>
	<script type="text/javascript">
		function postclose(){
			window.opener.location.reload();
			window.close();
		}
	</script>
</head>
<body>
	<div>
		<form:form modelAttribute="user" action="/userModify" method="post" enctype="multipart/form-data">
				<legend>프로필 수정</legend>
				<p>
					<label>ID </label>
					<form:input path="userid"  readonly="true"/>
				</p>
				<p>
					<label>Password 확인</label>
					<input type="password" name="checkPass" />
				<p>
					<label>Password </label>
					<form:password path="password" />
				</p>
				<p>
					<label>이름 </label>
					<form:input path="name"/>
				</p>
				<p>
					<label>설명 </label>
					<form:input path="introduce"/>
				</p>
				<p>
					<label>프로필이미지 </label>
					<input name="userimage" type="file">
				</p>
				<p>
					<input type="submit" value="등록" />
					<input type="button" value="취소" onclick="postclose();" />
				</p>
				<form:hidden path="image" />
			
		</form:form>
	</div>
</body>
</html>