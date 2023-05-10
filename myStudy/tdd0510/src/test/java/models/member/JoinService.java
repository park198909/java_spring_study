package models.member;

public class JoinService {
    private JoinValidator validator;
    private MemberDao memberDao;

    public JoinService(JoinValidator validator,MemberDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    }

    public void join(Member member) {
        validator.check(member);

        memberDao.register(member);
    }
}
