<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>코멘트 작성</title>
</head>
<body>

	<H3>코멘트 작성</H3>
	<P>
	<FORM NAME="comment">
		<textarea cols=40 rows=5
			onclick="if(this.value=='내용을 입력하세요'){this.value=''}">내용을 입력하세요</textarea>
		</br>
		<INPUT TYPE="submit" VALUE="확인" onClick="check(this.form)">
		<INPUT TYPE="button" VALUE="취소" onClick="history.back();">
	</FORM>

</body>
</html>