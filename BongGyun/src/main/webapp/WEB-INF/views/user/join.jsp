<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/common.css'/>" type="text/css" rel="stylesheet" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
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
	location.href="<c:url value='/'/>";
}

</script>
</head>
<body>
	<!-- 로그인 상태에 따른 처리 -->
	<c:choose>
		<c:when test="${not empty user}">
			<c:set value="/user/modifyProcess" var="actionUrl" />
			<c:set value="수정" var="btnText" />
			<c:set value="readonly='readonly'" var="readonly" />
		</c:when>
		<c:otherwise>
			<c:set value="/user/joinProcess" var="actionUrl" />
			<c:set value="회원가입" var="btnText" />
		</c:otherwise>
	</c:choose>
	<div id="wrap">
		<h2>회원가입</h2>
		<div id="joinForm">
		<form action="<c:url value='${actionUrl}'/>" name="joinForm" id="joinForm" method="post" enctype="multipart/form-data" onsubmit="return join(this);">
		<input type="hidden" name="referURL" value="${referURL}" />
		<table>
            <colgroup>
            	<col width="20%" />
            	<col width="" />
            </colgroup>
			<tr>
				<th><label for="id">ID</label></th>
				<td><input type="text" title="아이디를 입력하세요." name="id" maxlength="40" tabindex="1" value="${user.id}" ${readonly} /></td>
			</tr>
			<tr>
				<th><label for="password">비밀번호</label></th>
				<td><input type="password" title="비밀번호를 입력하세요." name="password" maxlength="40" tabindex="2" value="" /></td>
			</tr>
			<tr>
				<th><label for="name">이름</label></th>
				<td><input type="text" title="이름을 입력하세요." name="name" maxlength="40" tabindex="3" value="${user.name}" /></td>
			</tr>
			<tr>
				<th><label for="description">설명</label></th>
				<td><input type="text" title="설명을 입력하세요." name="description" maxlength="100" tabindex="4" value="${user.description}" /></td>
			</tr>
			<tr>
				<th><label for="profFile">프로필<br>이미지</label></th>
				<td>
					<c:if test="${not empty user.profPath }">
						<img src="<c:url value='/resources/profile/${user.profPath}'/>" style="width:60px;"/>
					</c:if>
					<input type="file" name="profFile" tabindex="4" value="" style="width:60%;" />
				</td>
			</tr>
		</table>
		<div id="btnList">
			<input type="submit" value="${btnText}" />
			<button type="button" onclick="cancel();">취소</button>
		</div>
		</form>
		</div>
	</div>
</body>
</html>