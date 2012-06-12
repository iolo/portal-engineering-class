<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ListTitle}</title>
</head>
<body>
	<table>
			<caption>${ListTitle}</caption>
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
					<td><img src="/images/userprofile/${user.image}" width=48 height=48/></td>
					<td>${user.name} </td>
					
					<td>${user.comment} </td>
					<td>${user.follow}
						<c:if test="${user.follow==true}"><a href="unfollow.do?target=${user.id}">Unfollow 하기</a></c:if>
						<c:if test="${user.follow==false}"><a href="follow.do?target=${user.id}">Follow 하기</a></c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>	
		</table>
	
</body>
</html>