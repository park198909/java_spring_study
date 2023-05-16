package models.member;

public class ServiceManager {
    public Member member() {
        return new Member();
    }

    public MemberDao memberDao() {
        return new MemberDao();
    }

    public JoinService joinService() {
        return new JoinService();
    }



}
