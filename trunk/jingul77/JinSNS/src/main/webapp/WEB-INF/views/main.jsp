<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>개인 SNS 페이지</title>
	<link href="/resources/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div>
		SNS 페이지 메인
	</div>
	<div>
	<p>
	    <input type="button" value="${user.id}" onclick="location.href='/personal'"/>
	    <input type="button" value="글쓰기" onclick="window.open('/write','win','width=450,height=350,toolbar=0,scrollbars=0,resizable=0')" />
		<input type="button" value="following"  />
		<input type="button" value="follower"  />
		<input type="button" value="전체 사용자"  />
	
	</p>
	</div>
	
	<div>
			<table>
			<thead>
				<tr>
					<th>프로필 이미지</th>
					<th>내용</th>
					<th>삭제</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${snsListModelList}" var="snsListModel">
				
					<tr>
						<td>머야이거</td>
						<td>${snsListModel.name}</td>
						<td>${snsListModel.sns}</td>
						<td>${snsListModel.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>