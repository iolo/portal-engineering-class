<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 등록</title>
	<link href="/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div>
		 전체 사용자
	</div>
	<div><p>
			<input type="button" value="${user.name}"onclick="location.href='/main'"/> 
	</p></div>
	<div>
		<table>
			<thead>
				<tr>
					<th>이미지</th>
					<th>이 름</th>
					<th>설 명</th>
					<th>follow</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>