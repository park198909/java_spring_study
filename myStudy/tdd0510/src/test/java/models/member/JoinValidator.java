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
        String email = member.getEmail();
        String mobile = member.getMobile();

        // 필수 입력 사항(userId, userPw, userPwRe, userNm, email. mobile) 체크 - null 또는 빈칸이면 JoinValidationException 발생
        requiredCheck(userId,new JoinValidationException("아이디를 입력하세요."));
        requiredCheck(userPw,new JoinValidationException("비밀번호를 입력하세요."));
        requiredCheck(userPwRe,new JoinValidationException("비밀번호를 확인하세요."));
        requiredCheck(userNm,new JoinValidationException("회원명을 입력하세요."));
        requiredCheck(email,new JoinValidationException("이메일을 입력하세요."));
        requiredCheck(mobile,new JoinValidationException("전화번호를 입력하세요."));

        // 자릿수 테스트 - 아이디 6~16자리, 비밀번호 8자리 이상, 전화번호 11자리 - 자릿수 벗어나면 JoinValidationException 발생
        lengthCheck(userId, 6, 16, new JoinValidationException("아이디는 6~16자리 이내로 입력하세요."));
        lengthCheck(userPw,8, new JoinValidationException("비밀번호는 8자리 이상 입력하세요."));
        lengthCheck(mobile, 11, 11, new JoinValidationException("전화번호 11자리를 모두 입력하세요."));

        // 아이디 중복가입 체크 - 이미 가입한 아이디면 JoinValidationException 발생
        if (memberDao.get(userId) != null) {
            throw  new DuplicateValidationException();
        }

        // 비밀번호 일치 체크 - 일치하지 않으면 JoinValidationException 발생, 비밀번호가 일치하지 않습니다.
        if (!userPw.equals(userPwRe)) {
            throw new JoinValidationException("비밀번호가 일치하지 않습니다.");
        }

        // 전화번호 010시작 체크 - 010으로 시작하지 않으면 JoinValidationException 발생, 전화번호는 010으로 시작해야 합니다.
        if (!mobile.substring(0,3).equals("010")) {
            throw new JoinValidationException("전화번호는 010으로 시작해야 합니다.");
        }

        // 이메일 형식 테스트 - 이메일에 @가 1개만 포함, 틀리면 JoinValidationException 발생, 이메일 형식(email@org.com)을 맞춰서 작성하세요.
        emailFormCheck(email, new JoinValidationException("이메일 형식(email@org.com)을 맞춰서 작성하세요."));



    }
}
