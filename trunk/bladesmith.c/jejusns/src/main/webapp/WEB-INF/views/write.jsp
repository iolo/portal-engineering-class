<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<link href="/resources/css/jeju.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript">
function parentWindowReload(){
	window.close();
	parent.window.opener.location.href="javascript:location.reload(true)";
}
</script>
</head>
<body>
	<div id="main">
		<form action="write" method="post">
		<fieldset>
			<legend>글쓰기</legend>
			<p>
				<textarea name="note" rows="6" cols="60"></textarea><br />
				<input type="submit" value="작성" onclick="parentWindowReload()"/>
				<input type="button" value="취소" onclick="self.close()"> 
			</p>
		</fieldset>
		</form>
	</div>
</body>
</html>