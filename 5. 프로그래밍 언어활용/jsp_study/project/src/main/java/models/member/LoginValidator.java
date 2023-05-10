package models.member;

import validators.Validator;

import javax.servlet.http.HttpServletRequest;

public class LoginValidator implements Validator<HttpServletRequest> {

    @Override
    public void check(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");

        // 필수 항목(userId, userPw) 체크 - null 또는 빈칸이면 LoginValidationException 발생
        requiredCheck(userId, new LoginValidationException("아이디를 입력하세요."));
        requiredCheck(userPw, new LoginValidationException("비밀번호를 입력하세요."));

        // 등록되지 않은 아이디 입력 시 LoginValidationException 발생, 등록되지 않은 아이디 입니다.
        MemberDao memberDao = new MemberDao();
        if (memberDao.get(userId) == null) {
            throw new LoginValidationException("등록되지 않은 아이디 입니다.");
        }

        // 비밀번호 오입력 시 LoginValidationException 발생, 아이디 또는 비밀번호를 확인하세요.
        String memberPw = memberDao.get(userId).getUserPw();
        if (!userPw.equals(memberPw)) {
            throw new LoginValidationException("아이디 또는 비밀번호를 확인하세요.");
        }

    }
}
