<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:main>
    <form method="post" action="<c:url value='/login' />" >
        <dl>
            <dt>아이디</dt>
            <dd>
                <input type="text" name="userId">
            </dd>
        </dl>
        <dl>
            <dt>비밀번호</dt>
            <dd>
                <input type="password" name="userPw">
            </dd>
        </dl>
        <div>
            <input type="checkbox" name="saveId" value="1" id="check"${cookie.saveId != null ? 'checked' : ''}>
            <label for="check">아이디 저장</label>
        </div>
        <button type="submit">로그인</button>
</layout:main>