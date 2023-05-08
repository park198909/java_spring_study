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

        MemberDao memberDao = new MemberDao();

        // 필수항목 체크1 - userId,userPw,userPwRe,userNm이 null 또는 빈칸이면 BadRequestException 발생
        requiredFieldTest(userId, new BadRequestException("아이디를 입력하세요"));
        requiredFieldTest(userPw, new BadRequestException("비밀번호를 입력하세요"));
        requiredFieldTest(userPwRe, new BadRequestException("비밀번호를 확인하세요"));
        requiredFieldTest(userNm, new BadRequestException("회원명을 입력하세요"));

        // 필수항목 체크2 - userPw와 userPw 자리수 체크 - 틀리면 BadRequestException 발생
        if (!userPw.equals(userPwRe)) {
            throw new BadRequestException("비밀번호가 일치하지 않습니다.");
        }

        // 필수항목 체크3 - userId : 6~16자리 userPw : 8자리 이상 - 자리수를 벗어나면 BadRequestException 발생
        lengthTest(userId, 6, 16, new BadRequestException("아이디는 6~16자리 이내로 입력하세요."));
        lengthTest(userPw, 8, new BadRequestException("비밀번호는 8자리 이상 입력하세요."));

        // 필수항목 체크4 - 중복가입 - 동일한 userId면 BadRequestException 발생
        if (memberDao.get(userId) != null) {
            throw new IdExistException();
        }
    }
}
