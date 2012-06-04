<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 등록</title>
<link href="/user/resources/menu.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="Header">컴퓨터 공학과 SNS입니다.</div>
	<div id="login">
		<form action="login" method="post">
			<fieldset>
				<p>
					<label>ID</label> <input type="text" name="id" />
				</p>
				<p>
					<label>Password</label> <input type="password" name="password" />
				</p>
				<p>
					<input type="submit" value="login" /><input type="button" value="회원가입" onclick="location.href='create.bs'"/>
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>