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
<form:form method="post" action="join.do" commandName="join" enctype="multipart/form-data">
	아이디 : <form:input path="id"/><br>
	비밀번호 : <form:input path="password"/><br>
	이름 : <form:input path="name"/><br>
	설명 : <form:textarea path="profile"/><br>
	사진 : <input type="file" name="file"/>
	<form:button>회원가입</form:button>
</form:form>
</body>
</html>