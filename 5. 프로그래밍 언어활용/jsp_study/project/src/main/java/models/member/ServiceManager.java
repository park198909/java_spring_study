package models.member;

public class ServiceManager {
    public MemberDao memberDao() {
        return new MemberDao();
    }

    public LoginValidator loginValidator() {
        return new LoginValidator();
    }

    public LoginService loginService() {
        return new LoginService(loginValidator(),memberDao());
    }

    public JoinValidator joinValidator() {
        joinValidator().setMemberDao(memberDao());
        return new JoinValidator();
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(),memberDao());
    }

    public Member member() {
        return new Member();
    }

}
