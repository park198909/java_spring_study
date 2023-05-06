package models.member;

public class JoinService {

    private JoinValidator validator;
    private MemberDao memberDao;

    public JoinService(JoinValidator validator, MemberDao memberDao) {
        this.memberDao = memberDao;
        this.validator = validator;
    }

    public void join(Member member) {
        validator.check(member);

        // 가입처리
        memberDao.insert(member);
    }
}
