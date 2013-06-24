<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/common.css'/>" type="text/css" rel="stylesheet" />
<title>로그인 페이지</title>
<script type="text/javascript">
function login(loginForm) {
    if (loginForm.id.value =="") {
        alert("아이디를 입력하세요");
        loginForm.id.focus();
        return false;
    } 
    else if (loginForm.password.value =="") {
        alert("비밀번호를 입력하세요");
        loginForm.password.focus();
        return false;
    }
	return true;
}

function popup(fail) {
	if(fail) {
		alert("아이디 또는 비밀번호가 잘못되었습니다.");	
        loginForm.id.focus();
	}
}

</script>
</head>
<body onload="popup(${fail})">
	<div id="wrap">
		<form action="<c:url value='/loginProcess'/>" name="loginForm" id="loginForm" method="post" onsubmit="return login(this);">
		<input type="hidden" name="referURL" value="${referURL}" />
		<div id="login">
			<h2>로그인</h2>
		   	<table>
		  		<tr>
		  			<td>ID</td>
		  			<td><input type="text" title="아이디를 입력하세요." name="id" maxlength="40" tabindex="1" /></td>
		  		</tr>
		  		<tr>
		  			<td>비밀번호</td>
		  			<td><input type="password" maxlength="40" title="비밀번호를 입력하세요." name="password" tabindex="2" /></td>
		  		</tr>
		  	</table>
		  	<input type="submit"  value="로그인" />
			<button type="button" onclick="window.close()">취소</button>
		</div>
		</form>
	</div>
</body>
</html>