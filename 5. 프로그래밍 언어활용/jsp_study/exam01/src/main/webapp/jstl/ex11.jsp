<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>ex11.jsp - 상단 </h1>

<%--
<c:import url="ex09.jsp" />
--%>

<c:import var="html" url="https://m.naver.com" />
${html}

<h1>ex11.jsp - 하단 </h1>