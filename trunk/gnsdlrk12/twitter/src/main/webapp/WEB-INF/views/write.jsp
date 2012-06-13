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
	글쓰기
	</div>
	<div>
		<form action="save" method="post">
			<fieldset>
				<legend>글쓰기</legend>
				<p>
					<label>글쓰기</label>
					<textarea rows="10" cols="40" name="content"></textarea>
				</p>
				<p>
					<input type="hidden" value="${userId}" name="userId"/>
					<input type="submit" value="저장"/>
					<input type="button" value="취소" onclick="postclose();" />
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>