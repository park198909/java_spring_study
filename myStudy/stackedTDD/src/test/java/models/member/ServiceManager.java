package models.member;

public class ServiceManager {
    public Member member() {
        return new Member();
    }

    public MemberDao memberDao() {
        return new MemberDao();
    }

    public JoinValidator joinValidator() {
        return new JoinValidator();
    }

    public JoinService joinService() {
        return new JoinService(joinValidator());
    }



}
