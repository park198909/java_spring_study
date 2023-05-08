package models.member;

import validators.Validator;

public class JoinService {
    private JoinValidator validator;

    public JoinService(JoinValidator validator) {
        this.validator = validator;
    }

    public void join(Member member) {

    }
}
