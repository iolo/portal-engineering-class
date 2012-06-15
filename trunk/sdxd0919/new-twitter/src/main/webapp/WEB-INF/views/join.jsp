<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<!-- 
	<link href="/userㅁ/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
	 -->
	<script type="text/javascript">
		function validation(){
			var url = document.URL;
			var id = document.joinForm.id.value;
			var name = document.joinForm.name.value;
			var password = document.joinForm.password.value;
			if((id=="") || (name=="") ||(password == "")){
				alert("id, password, name은 꼭 입력해야 합니다!");
			}else{
				document.joinForm.submit();
				document.joinForm.action = "/twitter/userSave";
			}
		}
	</script>	 
</head>
<body>
<center>
	<div id="JoinContent">
		<form name="joinForm" onsubmit="javascript:validation()" method="post" 
					enctype="multipart/form-data" >
			<center>
			<fieldset>	
				<legend >사용자 등록</legend>
				<table align="left">
				<tr>
					<td width="100" align="left">아이디</td>
					<td width="200" align="left"><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td width="100" align="left">이름</td>
					<td width="200" align="left"><input type="name" name="name" /></td>
				</tr>
				<tr>
					<td width="100" align="left">암호</td>
					<td width="200" align="left"><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td width="100" align="left">설명</td>
					<td width="200" align="left"><input type="text" width="350" name="description" /></td>
				</tr>
				<tr>
					<td width="100" align="left">프로필이미지</td>
					<td width="100" align="left"><input type="file" name="file"/></td>
				</tr>
				<tr>
					<td width="200" align="center"><input type="submit" value="등록" /></td>
					<td width="200" align="left">
						<input type="button" value="취소" onclick="javascript:history.back()">
					</td>
				</tr>
				</table>
			</fieldset>
			</center>
		</form>
	</div>
</center>
</body>
</html>