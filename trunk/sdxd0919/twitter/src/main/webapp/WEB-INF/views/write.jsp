<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글쓰기</title>
	<!-- 
	<link href="/user/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	-->
</head>
<body>
	<div id="WriteContent">
		<form action="/twitter/write" method="post">
			<legend>요즘 어떠신가요?</legend>
			<p>
				<input type="text" name="message" />
			</p>
			<p>
				<input type="submit" value="등록" onclick="javascript:window.opener.location.reload();window.close()"/>
				<a href="javascript:self.close()"><input type="button" value="취소"></a> 				
			</p>
		</form>
	</div>
</body>
</html>