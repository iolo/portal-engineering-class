<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form:form modelAttribute="post" action="/TwitterSJ/service/savePost"
		method="post">
		<fieldset>
			<legend>현재 하고 싶은 이야기는 무엇입니까?</legend>
			<p>
				<form:textarea path="content" />
				<form:errors path="content" />
				<form:hidden path="userId" />
			</p>
		</fieldset>
		<p>
			<input type="submit" value="확인" />
			<button type="button" onclick="window.close();">닫기</button>
		</p>
	</form:form>
</body>
</html>