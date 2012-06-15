<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SNS 페이지 메인</title>
</head>
<body>

	<div id="Header"></div>
	<div id="Menu">
	
				<input type="button" value= "${user.name}" onclick="location.href='/list'" />
				<input type ="button" value="글쓰기" onclick=""/>
				<input type ="button" value="Follwing" onclick=""/>
				<input type ="button" value="Follower" onclick=""/>
				<input type ="button" value="전체사용자" onclick=""/>
				<input type ="button" value="로그 아웃 " onclick="location.href='/login'"/>
			
	</div>
	<div id="Content">
		<table>
			<thead>
				<tr>
					<th>프로필 이미지</th>
					<th>이름</th>
					<th>내용</th>
					<th>날짜</th>
				</tr>
			</thead>
		</table>
	</div>

</body>
</html>