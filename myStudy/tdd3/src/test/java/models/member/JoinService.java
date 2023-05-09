package models.member;

public class JoinService {
    private JoinValidator validator;

    public void join(Member member) {
        validator = new JoinValidator();
        validator.check(member);
    }
}
