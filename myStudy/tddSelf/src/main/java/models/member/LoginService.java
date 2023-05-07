package models.member;

import javax.servlet.http.HttpServletRequest;

public class LoginService {

    LoginValidator validator;

    public LoginService(LoginValidator validator) {
        this.validator = validator;
    }
    public void login(HttpServletRequest request) {
        validator.check(request);
    }
}
