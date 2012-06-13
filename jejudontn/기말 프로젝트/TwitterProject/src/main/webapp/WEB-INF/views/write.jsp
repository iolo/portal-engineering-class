<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 등록</title>
	<link href="/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div>
		<form action="write/save" method="post">
			<fieldset>
				<legend>글쓰기</legend>
				<p>
					<label>글쓰기</label>
					<textarea rows="10" cols="40" name="twitt"></textarea>
				</p>
				<p>
					<input type="submit" value="저장"   onclick="window.close()"/>
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>