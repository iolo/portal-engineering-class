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
<center>
	<table>
		<tr>
			<td width="100" align="center" valign="middle">
				<strong>${user.id}</strong>
			</td>
			<td>
				<img src="/images/interface/editprofile" onClick="location.href='profileEdit_page'">
				<img src="/images/interface/write" onClick="javascript:window.open('twitWrite_page', '', 'location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no, width=300,height=400,left=0, top=0, scrollbars=no')">	
			</td>
		</tr>
	</table>

	
	<table>
			<caption>트윗's</caption>
			<tbody>
			<c:forEach items="${twitList}" var="twit" >
				<tr>
					<td><img src="/images/userprofile/${user.image}" width=36 height=36/></td>
					<td><strong><span style="font-size: 10pt;padding-right:10px">${twit.writer}</span></strong></td>
					<td width="400" bgcolor="#F0F0F0"><span style="font-size: 9pt">${twit.twit_text}</span></td>					
					<td width="70" align="right"><c:if test="${id==twit.writer}"><img src="/images/interface/delete" onClick="location.href='twitDelete.do?id=${twit.id}'"></c:if></td>
					<td width="80" align="center" valign="middle"><span style="font-size: 8pt">${twit.date}</span></td>
				</tr>
			</c:forEach>
			</tbody>	
		</table>
</center>

</body>
</html>