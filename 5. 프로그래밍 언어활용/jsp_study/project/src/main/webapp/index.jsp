<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main pageTitle="메인 페이지">
    <c:if test="${member == null}">
        <a href="/member/join">회원가입</a>
        <a href="/member/login">로그인</a>
    </c:if>
    <c:if>
        ${request.userNm}(${request.userId})님 로그인...
        <a href="/member/logout">로그아웃</a>
    </c:if>
</layout:main>
