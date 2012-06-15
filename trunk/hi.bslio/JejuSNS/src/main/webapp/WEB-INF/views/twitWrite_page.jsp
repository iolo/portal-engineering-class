<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="twitForm">
		오늘 어떠신가요?
		<input type="text" name="twit_text" placeholder="내용"/><br>
		<input type="button" value="저장" onClick="javascript:save()"/>
		<input type="button" value="취소" onClick="javascript:window.close()"/>
	</form>
	
	
	<script language=javascript>
	<!--
	function save() {
		var page = "twitWrite.do?twit_text=" + document.twitForm.twit_text.value;
		
		var openerType = typeof opener.location.href;
		if(openerType == 'string') {
			opener.location.href=page;
		}else{
			window.open(page,'','');
		}		
		self.close();
	}
	-->
	</script>
</body>
</html>