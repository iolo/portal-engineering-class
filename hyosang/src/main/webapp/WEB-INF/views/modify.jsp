<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<title>회원 정보 수정</title>
	<style type="text/css">
		
	</style>
</head>

<h1>회원 정보 수정</h1>
<form name="modifyForm" action="<c:url value='/modifyprocess'/>" method="post">
	<label>
		아이디 <input type="text" name="userId" value="${user.userId}" readonly /><br>
	</label>
	<label>
		패스워드 <input type="password" name="password" value="${user.password}" /><br>
	</label>
	<label>
		이름 <input type="text" name="userName" value="${user.userName}" /><br>
	</label>
	<label>
		설명 <input type="text" name="userInfo" value="${user.userInfo}" /><br>
	</label>
	<label>
		프로필 사진 <input type="hidden" name="userImagePath" value="${user.userImagePath}" />
	</label>
	<input type="submit" value="수정하기" />
	<button>취소</button>
</form>

</body>
</html>
