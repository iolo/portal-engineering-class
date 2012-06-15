<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
</head>
<body>
<form:form method="post" action="update.do" commandName="join" enctype="multipart/form-data">
${user.id }
	아이디 : <form:input path="id" placeholder="아이디" disabled="true" value="${user.id }"/><br>
			<form:hidden path="id" value="${user.id }"/>
	비밀번호 : <form:password path="password" placeholder="비밀번호"  value="${user.password }"/><br>
	이름 : <form:input path="name" placeholder="이름" value="${user.name }"/><br>
	설명 : <form:input path="profile" placeholder="설명" value="${user.profile }"/><br>
	사진 : <input type="file" name="file"/>
	<form:button>수정</form:button>
</form:form>
</body>
</html>