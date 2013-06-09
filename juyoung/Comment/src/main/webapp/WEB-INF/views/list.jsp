<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list</title>
</head>
<body>
	<div id="login">
		<button onclick="location.href='./write'">글쓰기</button>
	</div>
	<%
		//이하 반복 시작
	%>
	<div id="line">
		<div id=""></div>
		<div id="userName"></div>
		<div id="text"></div>
		<div id="btn">
			<button>추천</button>
			<button>반대</button>
		</div>
	</div>
	<%
		//이하 반복 종료
	%>
</body>
</html>