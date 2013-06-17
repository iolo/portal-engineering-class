<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
<script type="text/javascript">
function login() {
    if (document.loginForm.id.value =="") {
        alert("아이디를 입력하세요");
    } else if (document.loginForm.password.value =="") {
        alert("비밀번호를 입력하세요");
    } else {
        document.loginForm.action="<c:url value='/loginProcess'/>";
        document.loginForm.submit();
    }
}
</script>
</head>
<body>
	<form name="loginForm" id="loginForm" method="post" onsubmit="login(); return false;">
	<div id="login">
		<h2>로그인</h2>
	   	<table>
	  		<tr>
	  			<td>ID</td>
	  			<td><input type="text" title="아이디를 입력하세요." id="id" name="id" maxlength="40" tabindex="1" /></td>
	  		</tr>
	  		<tr>
	  			<td>비밀번호</td>
	  			<td><input type="password" maxlength="40" title="비밀번호를 입력하세요." id="password" name="password" tabindex="2" /></td>
	  		</tr>
	  	</table>
	  	<input type="submit"  value="로그인" />
	  	<input type="reset" value="취소" />
	</div>
	</form>
</body>
</html>