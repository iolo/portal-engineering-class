<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ڸ�Ʈ �ۼ�</title>
</head>
<body>

	<H3>�ڸ�Ʈ �ۼ�</H3>
	<P>
	<FORM NAME="comment">
		<textarea cols=40 rows=5
			onclick="if(this.value=='������ �Է��ϼ���'){this.value=''}">������ �Է��ϼ���</textarea>
		</br>
		<INPUT TYPE="submit" VALUE="Ȯ��" onClick="check(this.form)">
		<INPUT TYPE="button" VALUE="���" onClick="history.back();">
	</FORM>

</body>
</html>