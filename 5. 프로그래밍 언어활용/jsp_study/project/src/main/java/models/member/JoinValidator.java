package models.member;

import validators.Validator;

public class JoinValidator implements Validator<Member> {

    private MemberDao memberDao;
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void check(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String userPwRe = member.getUserPwRe();
        String userNm = member.getUserNm();

        // 필수 입력 사항(userId, userPw, userPwRe, userNm) 체크 - null 또는 빈칸이면 JoinValidationException 발생
        requiredCheck(userId, new JoinValidationException("아이디를 입력하세요."));
        requiredCheck(userPw, new JoinValidationException("비밀번호를 입력하세요."));
        requiredCheck(userPwRe, new JoinValidationException("비밀번호를 확인하세요."));
        requiredCheck(userNm, new JoinValidationException("회원명을 입력하세요."));

        // 자릿수 테스트 - 아이디(6~16자리), 비밀번호(8자리 이상) : 자릿수 벗어나면 JoinValidationException 발생
        lengthCheck(userId,6,16 ,new JoinValidationException("아이디는 6~16자리 이내로 입력하세요."));
        lengthCheck(userPw,8 ,new JoinValidationException("비밀번호는 8자리 이상 입력하세요."));

        // 비밀번호 일치여부 확인 - userPw와 userPwRe가 일치하지 않으면 JoinValidationException 발생
        if (!userPw.equals(userPwRe)) {
            throw new JoinValidationException("비밀번호가 일치하지 않습니다.");
        }

        // 중복가입 체크 - 동일한 아이디가 이미 있으면 ExistValidationException 발생
        MemberDao memberDao = new MemberDao();
        if(memberDao.get(userId) != null) {
            throw new ExistValidationException();
        }




    }
}
