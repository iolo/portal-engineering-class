<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>write</title>
</head>
<body>
<form name="comment" action="./write.save" method="post">
	${profile_url}<input type="hidden" name="userUrl" value="${profile_url}"><br />
	${name}<input type="hidden" name="writer" value="${name}"><br />
	commentText<input type="text" name="commentText"><br />
	<button type="submit">write</button>
</form>
<button onclick="location.href='http://localhost:8080/jejunu/list'">취소</button>

</body>
</html>