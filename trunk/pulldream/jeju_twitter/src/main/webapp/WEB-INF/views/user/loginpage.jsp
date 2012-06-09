<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<script language="JavaScript">
function openNewWindow(window) {
open (window,"NewWindow","left=100, top=100, toolbar=yes, location=yes, directories=yes, status=yes, menubar=yes, scrollbars=yes, resizable=yes, width=400, height=400");
}
</script>

  
안녕하세요
<input type="button" value="글쓰기" onClick="javascript:openNewWindow('writeform')"/>
<input type="button" value="Follower" action=""/>
<a href="getfollowing.do"><input type="button" value="Following" /></a>
<input type="button" value="전체사용자"/>
