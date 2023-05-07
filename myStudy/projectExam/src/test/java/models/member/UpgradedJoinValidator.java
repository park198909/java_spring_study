package models.member;

import validators.RequiredValidator;
import validators.Validator;

public class UpgradedJoinValidator implements Validator<Member>, RequiredValidator {
    @Override
    public void check(Member member) {

    }
}
