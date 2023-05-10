package models.member;

import validators.Validator;

import javax.servlet.http.HttpServletRequest;

public class LoginValidator implements Validator<HttpServletRequest> {

    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void check(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");

        // 필수항목(userId, userPw) 체크 - null 또는 빈칸이면 LoginValidationException 발생
        requiredCheck(userId, new LoginValidationException("아이디를 입력하세요"));
        requiredCheck(userPw, new LoginValidationException("비밀번호를 입력하세요"));

        // 미등록 아이디 체크 - 미등록 아이디 입력 시 ExistIdValidationException 발생, 미등록된 아이디 입니다.
        if (memberDao.get(userId) == null) {
           throw new ExistIdValidationException();
        }

        //비밀번호 체크 - 비밀번호 틀리면 PasswordValidationException 발생, 아이디 또는 비밀번호를 확인하세요.
        Member member = memberDao.get(userId);
        if (!member.getUserPw().equals(userPw)) {
            throw new PasswordValidationException();
        }

    }
}
