<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript">
function join(joinForm) {
    if (joinForm.id.value =="") {
        alert("아이디를 입력하세요");
        joinForm.id.focus();
        return false;
    } 
    else if (joinForm.password.value =="") {
        alert("비밀번호를 입력하세요");
        joinForm.password.focus();
        return false;
    } 
    else if (joinForm.name.value =="") {
        alert("이름을 입력하세요");
        joinForm.name.focus();
        return false;
    }
    return true;
}
function cancel() {
	location.href="${referURL}";
}
</script>
</head>
<body>
	<div id="wrap">
		<h2>회원가입</h2>
		<form action="<c:url value='/joinProcess'/>" name="joinForm" id="joinForm" method="post" onsubmit="return join(this);">
		<input type="hidden" name="referURL" value="${referURL}" />
		<table>
			<tr>
				<th><label for="id">ID</label></th>
				<td><input type="text" title="아이디를 입력하세요." name="id" maxlength="40" tabindex="1" /></td>
			</tr>
			<tr>
				<th><label for="password">비밀번호</label></th>
				<td><input type="password" title="비밀번호를 입력하세요." name="password" maxlength="40" tabindex="2" /></td>
			</tr>
			<tr>
				<th><label for="name">이름</label></th>
				<td><input type="text" title="이름을 입력하세요." name="name" maxlength="40" tabindex="3" /></td>
			</tr>
			<tr>
				<th><label for="description">설명</label></th>
				<td><input type="text" title="설명을 입력하세요." name="description" maxlength="100" tabindex="4" /></td>
			</tr>
			<tr>
				<th><label for="profPath">프로필이미지</label></th>
				<td><input type="file" name="profPath" maxlength="40" tabindex="4" /></td>
			</tr>
		</table>
		<input type="submit" value="회원가입" />
		<button type="button" onclick="cancel();">취소</button>
		</form>
	</div>
</body>
</html>