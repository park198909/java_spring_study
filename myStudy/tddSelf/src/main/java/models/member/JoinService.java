package models.member;

public class JoinService {

    JoinValidator validator;
    MemberDao memberDao;

    public JoinService(JoinValidator validator,MemberDao memberDao) {
        this.memberDao = memberDao;
        this.validator = validator;
    }

    public void join(Member member) {
        // 가입 유효성 검사
        validator.check(member);
        
        // 회원가입 처리
        memberDao.memberSave(member);
    }
}
