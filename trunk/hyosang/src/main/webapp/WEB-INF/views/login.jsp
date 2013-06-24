<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<title>로그인</title>
	<style type="text/css">
		body{width:250px; text-align:center;}
		.form-login{max-width: 300px;padding: 19px 29px 29px;margin: 0 auto 20px;background-color: #fff;border: 1px solid #e5e5e5;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);-moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);box-shadow: 0 1px 2px rgba(0,0,0,.05);}
	</style>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.css'/>" />
</head>

<h1>로그인</h1>
<form class="form-login" name="loginForm" action="<c:url value='/loginprocess'/>" method="post">
	<input class="input-block-level" type="text" name="userId" placeholder="아이디" /><br>
	<input class="input-block-level" type="password" name="password" placeholder="비밀번호" /><br>
	<input class="btn" type="submit" value="로그인" />
	<button class="btn">취소</button>
</form>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>

</body>
</html>
