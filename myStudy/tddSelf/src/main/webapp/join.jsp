<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:main>
    <form method="post" action="<c:url value='/join' />" >
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
        <dl>
            <dt>비밀번호 확인</dt>
            <dd>
                <input type="password" name="userPwRe">
            </dd>
        </dl>
        <dl>
            <dt>회원명</dt>
            <dd>
                <input type="text" name="userNm">
            </dd>
        </dl>
        <div>
            <input type="checkbox" id="check" name="agree" value="1">
            <label for="check">약관에 동의합니다.</label>
        </div>
        <button type="reset">다시작성</button>
        <button type="submit">가입하기</button>
    </form>
</layout:main>