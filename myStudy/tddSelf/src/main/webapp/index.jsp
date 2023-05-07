<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:main>
    <c:if test="${member == null}">
        <a href="<c:url value='/join' />">회원가입</a>
        <a href="<c:url value='/login' />">로그인</a>
    </c:if>
    <c:if test="${member != null}">
        ${member.userNm}({member.userId})님 로그인...
        <a href="<c:url value='/logout' />">로그아웃</a>
    </c:if>
</layout:main>