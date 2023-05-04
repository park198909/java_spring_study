<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
    <head>
        <title>메인 화면</title>
    </head>
    <body>
        <form method="post" action="join.jsp">
            <button type="submit">회원가입</button>
        </form>
        <form method="post" action="login.jsp">
            <button type="submit">로그인</button>
        </form>
    </body>
</html>