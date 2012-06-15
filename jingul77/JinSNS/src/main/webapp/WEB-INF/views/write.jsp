<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 등록</title>
	<link href="/resources/jin.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div>
		<form action="write" method="post">			
			<label>글쓰기</label><br><br>
			<textarea rows="20" cols="50" name="sns"></textarea><br><center>
		
			<input type="submit" value="저장" onclick="window.close()"/>
			<input type="button" value="취소" onclick="window.close()"/></center>
		</form>
	</div>
</body>
</html>