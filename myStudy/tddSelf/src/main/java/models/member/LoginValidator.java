package models.member;

import validators.Validator;

import javax.servlet.http.HttpServletRequest;

public class LoginValidator implements Validator<HttpServletRequest> {

    private MemberDao memberDao;

    public LoginValidator(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void check(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");

        // 필수항목 검증 - userId, userPw이 null 또는 빈칸이면 BadRequestException 발생
        requiredFieldTest(userId,new BadRequestException("아이디를 입력하세요."));
        requiredFieldTest(userPw,new BadRequestException("비밀번호를 입력하세요."));

        // 등록되지 않은 아이디로 로그인 시도하면 BadRequestException 발생, 등록되지 않은 아이디입니다.
        if (memberDao.get(userId) == null) {
            throw new BadRequestException("등록되지 않은 아이디입니다.");
        }

        // 패스워드 불일치 테스트 - 비밀번호가 맞지 않는 경우  - BadRequestException 발생, 아이디 또는 비밀번호가 일치하지 않습니다.
        Member member = memberDao.get(userId);
        if (!userPw.equals(member.getUserPw())) {
           throw new BadRequestException("아이디 또는 비밀번호가 일치하지 않습니다.") ;
        }
    }
}
