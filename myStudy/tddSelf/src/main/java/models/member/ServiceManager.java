package models.member;

public class ServiceManager {

    public Member member() {
        return new Member();
    }

    public MemberDao memberDao() {
        return new MemberDao();
    }

    public JoinValidator joinValidator() {
        JoinValidator validator = new JoinValidator();
        validator.setMemberDao(memberDao());
        return validator;
    }

    public LoginValidator loginValidator() {
        return new LoginValidator(memberDao());
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(),memberDao());
    }

    public LoginService loginService() {
        return new LoginService(loginValidator(),memberDao());
    }

}
