<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="writeTwit.submit">
		<input type="text" name="twit_text" placeholder="내용"/><br>
		<input type="submit" value="저장" onClick="javascript:save()"/>
		<input type="button" value="취소" onClick="javascript:window.close()"/>
	</form>
	
	
	<script language=javascript>
	<!--
	function save() {
		// 저장 페이지로 넘어가고 저장 완료후 아래 기능을 실행하도록 해야함
		opener.location.reload(true);
		self.close();
	}
	-->
	</script>
</body>
</html>