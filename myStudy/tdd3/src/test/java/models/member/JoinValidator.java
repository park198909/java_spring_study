package models.member;

import validators.Validator;

public class JoinValidator implements Validator<Member> {

    @Override
    public void check(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String userPwRe = member.getUserPwRe();
        String userNm = member.getUserNm();

        // 필수 항목 체크 - userId,userPw,userPwRe,userNm이 null 또는 빈칸일 때 JoinValidationException 발생
        requiredCheck(userId, new JoinValidationException("아이디를 입력하세요."));
        requiredCheck(userPw, new JoinValidationException("비밀번호를 입력하세요."));
        requiredCheck(userPwRe, new JoinValidationException("비밀번호를 확인하세요."));
        requiredCheck(userNm, new JoinValidationException("회원명을 입력하세요."));
    }
}
