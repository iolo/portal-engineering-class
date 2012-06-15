<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jejuSNS</title>
<link href="/resources/css/index.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="Header">컴퓨터 공학과 SNS입니다.</div>
	<div id="login">
		<form action="login" method="post">
			<fieldset>
				<img src="resources/background/door.jpg" />
				<p>
					<label>ID</label> <input type="text" name="id" class="input" />
				</p>
				<p>
					<label>Password</label> <input type="password" name="password"
						class="input" />
				</p>
				<div id="button_gap">
					<p>
						<input type="submit" value="login" class="button" /> <input
							type="button" value="회원가입" onclick="location.href='create.bs'"
							class="button" />
					</p>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>