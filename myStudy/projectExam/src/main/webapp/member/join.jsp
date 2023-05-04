<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
    <head>
        <title>회원가입 페이지</title>
    </head>
    <body>
        <form method="post" action="joinSuccess.jsp">
            <dl>
                <dt>아이디</dt>
                <dd>
                    <input type="text" name="아이디">
                </dd>
                <dt>비밀번호</dt>
                <dd>
                    <input type="password" name="비밀번호">
                </dd>
                <dt>회원명</dt>
                <dd>
                    <input type="text" name="회원명">
                </dd>
                <dt>성별</dt>
                <dd>

                        <input type="checkbox" name="남성" id="male">
                        <label for="male">남
                        <input type="checkbox" name="여성" id="female">
                        <label for="female">여
                </dd>
            </dl>
            <button type="reset">다시작성</button>
            <button type="submit">제출하기</button>
        </form>
    </body>
</html>