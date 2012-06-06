<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인 SNS 페이지</title>
</head>
<body>
	${id}
	<input type="button" value="새로고침 테스트" onClick="javascript:reload()"/>
	<input type="button" value="글쓰기" onClick="javascript:window.open('writeSns', '', 'location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no, width=300,height=400,left=0, top=0, scrollbars=no')"/>
	
	<script language=javascript>
	<!--
	function reload() {
		document.location.replace('Individual?id=${id}');		
	}
	-->
	</script>
</body>
</html>