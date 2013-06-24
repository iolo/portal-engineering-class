<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<title>로그인</title>
	<style type="text/css">
		
	</style>
</head>

<h1>로그인</h1>
<form name="loginForm" action="<c:url value='/loginprocess'/>" method="post">
	<label>
		아이디 <input type="text" name="userId" /><br>
	</label>
	<label>
		패스워드 <input type="password" name="password" /><br>
	</label>
	<input type="submit" value="로그인" />
	<button>취소</button>
</form>

</body>
</html>
