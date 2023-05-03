<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url var="action" value="/jstl/ex21.jsp" />

<form method="post" action="${action}">
    <input type="text" name="name">
    <button type="submit">전송하기</button>
</form>
