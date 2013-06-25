<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<title>회원 정보 수정</title>
	<style type="text/css">
		body{width:300px; text-align:center;}
		form{max-width: 300px;padding: 19px 29px 29px;margin: 0 auto 20px;background-color: #fff;border: 1px solid #e5e5e5;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);-moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);box-shadow: 0 1px 2px rgba(0,0,0,.05);}
	</style>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.css'/>" />
</head>

<h1>회원 정보 수정</h1>
<form name="modifyForm" action="<c:url value='/modifyprocess'/>" method="post">
	<label>
		아이디 <input class="input-block-level" type="text" name="userId" value="${user.userId}" readonly /><br>
	</label>
	<label>
		패스워드 <input class="input-block-level" type="password" name="password" value="${user.password}" /><br>
	</label>
	<label>
		이름 <input class="input-block-level" type="text" name="userName" value="${user.userName}" /><br>
	</label>
	<label>
		설명 <input class="input-block-level" type="text" name="userInfo" value="${user.userInfo}" /><br>
	</label>
	<label>
		<input type="hidden" name="userImagePath" value="${user.userImagePath}" />
	</label>
	<input class="btn" type="submit" value="수정하기" />
	<a href="javascript:history.back();" class="btn">취소</a>
</form>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>
