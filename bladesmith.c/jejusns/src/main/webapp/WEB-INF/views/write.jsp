<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<link href="/resources/css/write.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript">
	function parentWindowReload() {
		window.close();
		parent.window.opener.location.href = "javascript:location.reload(true)";
	}
</script>
</head>
<body>
	<div id="write">
		<form action="write" method="post">
			<fieldset>
				<legend>글쓰기</legend>
				<p>
					<textarea name="note" rows="8"></textarea>
					<br />
				<div id="button_gap">
					<input type="submit" value="작성" onclick="parentWindowReload()"
						class="button" /> <input type="button" value="취소"
						onclick="self.close()" class="button" />
				</div>
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>