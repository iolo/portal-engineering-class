<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"></script>
<title>글쓰기</title>
</head>
<body>
	<script language="javascript">
		function sendit() {
			var url = "/serivce/tweetAdd?tweet="
					+ document.tweetform.tweet.value + "&url="
					+ opener.document.URL;
			opener.document.location.href = url;
			self.close();
		}
	</script>
	<div align="center">
		<form name="tweetform">
			요즘 어떠신가요?
			<p>
				<input type=text name=tweet style="width:90%; padding: 5px">
			<p>
				<a href="javascript:sendit()"><input type="button" value="확인" /></a>
				<a href="javascript:self.close()"><input type="button"
					value="취소" /></a>
		</form>
	</div>
</body>
</html>