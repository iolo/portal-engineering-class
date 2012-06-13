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

<script type="text/javascript" language="javascript">
function open_reload(){
	var page = "write.do?content="+document.writeTwitt.content.value;
	window.opener.document.location.href= page;
	window.close();
}
</script>
<body>

<form:form commandName="twitt" name="writeTwitt">
	요즘 어떠신가요??<br>
	<!-- <input type="text" name="content"/> -->
	<form:textarea name="content" path="content"/><br>
	<form:button onclick="open_reload();">입력</form:button>
	<input type="button" onClick="window.close();" value="취소"/>
</form:form>
</body>
</html>