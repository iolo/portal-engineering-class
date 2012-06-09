<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>트윗 글쓰기</title>
</head>
<body>
<form action="write.do">
	요즘 어떠신가요??<br>
	<input type="text" name="content"/>
	<input type="submit"/>
	<input type="button" value="취소"/>
</form>
</body>
</html>