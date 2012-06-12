<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인 SNS 페이지</title>
</head>
<body>
	${user.id}
	<input type="button" value="프로필 수정" onClick="location.href='profileEdit_page'"/>
	<input type="button" value="글쓰기" onClick="javascript:window.open('twitWrite_page', '', 'location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no, width=300,height=400,left=0, top=0, scrollbars=no')"/>
	
	<table>
			<caption>트윗's</caption>
			<thead>
				<tr>
					<th> </th>
					<th>작성자</th>
					<th>내용</th>
					<th> </th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${twitList}" var="twit" >
				<tr>
					<td><img src="/images/userprofile/${user.image}" width=48 height=48/></td>
					<td>${twit.writer} </td>
					<td>${twit.twit_text} </td>
					<td><a href="twitDelete.do?id=${twit.id}">ㅁ삭제ㅁ</a></td>
					<td>${twit.date} </td>
					<!-- <td><a href="modify?id=${user.id}">수정</a></td> -->
					<!-- <td><a href="remove?id=${user.id}">삭제</a></td> -->
				</tr>
			</c:forEach>
			</tbody>	
		</table>
	
</body>
</html>