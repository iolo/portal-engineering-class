<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 등록</title>
	<script type="text/javascript">
		function postclose(){
			window.opener.location.reload();
			window.close();
		}
	</script>
</head>
<body>
	<div>
		<form action="write" method="post">
				<legend>요즘 어떠신가요?</legend>
				<p>
					<textarea width=300px rows="10" cols="40" name="content"></textarea>
				</p>
				<p>
					<input type="hidden" value="${userId}" name="userId"/>
					<input type="submit" value="저장"/>
					<input type="button" value="취소" onclick="postclose();" />
				</p>
		</form>
	</div>
</body>
</html>