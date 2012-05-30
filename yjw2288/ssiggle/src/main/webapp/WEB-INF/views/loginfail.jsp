<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
아이디나 비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.
<form action="login" method="post">
	아이디 : <input type="text" name="id"><br/>
	비밀번호 : <input type="password" name="password"><br/>
	<input type="submit" value="로그인"/>
</form>