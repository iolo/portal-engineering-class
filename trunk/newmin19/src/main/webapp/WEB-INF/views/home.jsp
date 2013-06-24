<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>댓글 시스템</h1>
	<input type="button" value="회원가입" onclick="location.href='join'">
	<input type="button" value="글쓰기" onclick="location.href='login'">
	
	<table>
		<c:forEach var="result" items="${comments}" varStatus="status">
			<tr>
				<td><c:out value="${result.image}"/></td>
				<td><c:out value="${result.name}"/></td>
				<td><c:out value="${result.comment}"/></td>
				<td><c:out value="${result.likeCount}"/></td>
				<td><c:out value="${result.unlikeCount}"/></td>
				<td><c:out value="${result.regdate}"/></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>