<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/css/content_style.css" rel="stylesheet" type="text/css" media="all" />
<title>Welcome To Jeju Twitt</title>
</head>
<body>
<div >
	<c:choose>
		<c:when test="${pageType=='/mytwitt' }">
			<jsp:include page="user/loginpage_with_update.jsp"/><br>
		</c:when>
		<c:otherwise>
			<jsp:include page="user/loginpage.jsp"/><br>
		</c:otherwise>
	
	</c:choose>
	<jsp:include page="${pageType }"/>
</div>
</body>
</html>