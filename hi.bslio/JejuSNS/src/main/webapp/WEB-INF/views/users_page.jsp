<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${titleString}</title>
</head>
<body>
	${id} ${f:length(users)}
	<table>
			<caption>${titleString}</caption>
			<thead>
				<tr>
					<th> </th>
					<th>이름</th>
					<th>코멘트</th>
					<th>follow</th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${users}" var="user" >
				<tr>
					<td>없듬 </td>
					<td>${user.name}<c:if test="${user.name == 'parkjt' }">wowwowwow!!!</c:if> </td>
					
					<td>${user.comment} </td>
					<td>팔로우/언팔로우버튼 </td>
				</tr>
			</c:forEach>
			</tbody>	
		</table>
	
</body>
</html>