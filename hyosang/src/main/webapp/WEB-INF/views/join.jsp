<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<title>회원 가입</title>
	<style type="text/css">
		
	</style>
</head>

<h1>회원 가입</h1>
<form name="joinForm" action="<c:url value='/joinprocess'/>" method="post">
	<label>
		아이디 <input type="text" name="userId" /><br>
	</label>
	<label>
		패스워드 <input type="password" name="password" /><br>
	</label>
	<label>
		이름 <input type="text" name="userName" /><br>
	</label>
	<label>
		설명 <input type="text" name="userInfo" /><br>
	</label>
	<label>
		프로필 사진
	</label>
	<input type="submit" value="회원가입" />
	<button>취소</button>
</form>

</body>
</html>
