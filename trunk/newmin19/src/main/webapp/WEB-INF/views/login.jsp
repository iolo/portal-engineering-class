<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>로그인</title>
<script type="text/javascript">
function popup(fail){
	if(fail){
		alert("올바른 ID/PassWord를 입력하세요.");
	}
}
</script>
</head>
<body onload="popup(${fail})">
	<h3>로그인</h3>
	<form action="<c:url value="/loginProcess" />" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" id="id" value="" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password"
					value="" /></td>
			</tr>
		</table>

		<INPUT TYPE="submit" VALUE="확인" onClick="check(this.form)"> <INPUT
			TYPE="button" VALUE="취소" onClick="history.back();">
	</form>
</body>
</html>