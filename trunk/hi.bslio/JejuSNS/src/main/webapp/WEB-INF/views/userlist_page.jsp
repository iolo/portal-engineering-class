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
<center>
	<strong>${ListTitle}</strong><p>
	<table>
			<tbody>
			
			<c:forEach items="${users}" var="user" >
				<tr>
					<td><img src="/images/userprofile/${user.image}" width=36 height=36/></td>
					<td><strong><span style="font-size: 10pt;padding-right:10px">${user.name}</span></strong></td>					
					<c:if test="${user.follow==true}"><td width="400" bgcolor="#F0F0F0"><span style="font-size: 9pt">${user.comment}</span></td></c:if>
					<c:if test="${user.follow==false}"><td width="400"><span style="font-size: 9pt">${user.comment}</span></td></c:if>
					<td>
						<c:if test="${user.follow==true}"><img src="/images/interface/unfollow" onClick="location.href='unfollow.do?target=${user.id}'"></c:if>
						<c:if test="${user.follow==false}"><img src="/images/interface/follow" onClick="location.href='follow.do?target=${user.id}'"></c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>	
		</table>
</center>
</body>
</html>