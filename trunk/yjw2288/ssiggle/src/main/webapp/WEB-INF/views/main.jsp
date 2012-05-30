<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
메인페이지
<br />
${user.id } (${user.introduce })
<a href="modifyuser?id=${user.id}">프로필 수정</a>
<a href="writessiggle.jeju?id=${user.id}">글쓰기</a>
<br />
<table id="usertable" border='1'>
	<tbody>
		<c:forEach items="${ssigglelist}" var="ssiggle">
			<tr>
				<td><img src="/ssiggle/resources/userimage/${user.image}"
					width="50" height="50"></td>
				<td>${ssiggle.text}</td>
				<td><a hrep="deletessiggle.jeju?id=${user.id }">삭제</a></td>
				<td>${ssiggle.time}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/ssiggle/logout">로그아웃</a>
