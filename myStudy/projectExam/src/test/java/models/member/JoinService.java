package models.member;

import validators.Validator;

public class JoinService {
    private Validator validator;

    public void join(Member member) {
        validator.check(member);
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}
