<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<script language="javascript">
		function sendit() {
			var url = "/"
			window.open(opener.document.URL, '', 'with=100, height=100');
			opener.document.location.href=url;
			self.close();
		}
	</script>
	<form name="tweetform">
		요즘 어떠신가요? <p> 
		<input type=text name=tweet><p>
		 <a	href="javascript:sendit()">확인</a>
	</form>
</body>
</html>