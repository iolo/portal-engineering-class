<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>메인화면</title>
	<!-- 
	<link href="/user/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	-->
	<script type="text/javascript">
		function validation(){
			var id = document.loginForm.id.value;
			var password = document.loginForm.password.value;
			if((id=="") ||(password == "")){
				alert("id, password, name은 꼭 입력해야 합니다!");
			}else{
				document.loginForm.submit();
				document.loginForm.action = "/twitter/login";
			}
		}
	</script>	 
	
</head>
<body>
<center>
	<div id="Header">
		<h3>Animal World 오신것을 환영합니다.</h3>
		<p>
			<img src="/twitter/resources/image/main.png" width="500" height="500"/>
		</p>
	</div>

	<div id="LoginContent">
		<form name="loginForm" onsubmit="javascript:validation()" method="post" accept-charset="UTF-8">
				<table width="500" align="center">
					<tr>
						<td align="right" width="500">
						  ID <input type="text" name="id" />
						</td>
					</tr>
					<tr>	
						<td align="right" width="500"> 
							PW <input type="password" name="password" />
						</td>
					</tr>
					<tr align="right">
						<td align="right" width="500">
							<input type="submit" value="로그인" />
							<a href="/twitter/join"><input type="button" value="회원가입" /></a>
						</td>
					</tr>
				</table>
		</form>
	</div>
</center>	
</body>
</html>