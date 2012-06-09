<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인 페이지</title>
</head>
<body>
	<div id="Header">
		${user.userid }
		${user.password }
		 <input type="button"
				value="글쓰기"
				onclick="window.open('/write','NewWindow','width=400,height=380,toolbar=0,scrollbars=0,resizable=0');" />
	</div>
	<div id="Content">
		<c:forEach items="${posts }" var="post">
			${post.content }
			${post.name }
			<br/>
		</c:forEach>
	</div>
</body>
</html>