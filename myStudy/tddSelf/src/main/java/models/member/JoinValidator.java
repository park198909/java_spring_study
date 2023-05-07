package models.member;

import validator.Validator;

public class JoinValidator implements Validator<Member> {
    @Override
    public void check(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String userPwRe = member.getUserPwRe();
        String userNm = member.getUserNm();
        String checkId = member.getCheckId();
        requiredFieldCheck(userId,new JoinValidationException("아이디를 입력하세요."));
        requiredFieldCheck(userPw ,new JoinValidationException("비밀번호를 입력하세요."));
        requiredFieldCheck(userPwRe ,new JoinValidationException("비밀번호를 확인하세요."));
        requiredFieldCheck(userNm ,new JoinValidationException("회원명을 입력하세요."));
        userIdLengthCheck(userId, new JoinValidationException("아이디는 6~16자리 이내로 입력하세요."));
        userPwLengthCheck(userPw, new JoinValidationException("비밀번호는 8자리 이상 입력하세요."));
        duplicatedCheck(userId,checkId, new JoinValidationException("이미 존재하는 아이디 입니다."));
    }
}
