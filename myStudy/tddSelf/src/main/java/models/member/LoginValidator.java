package models.member;

import validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class LoginValidator implements Validator<HttpServletRequest> {
    @Override
    public void check(HttpServletRequest request ) {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        requiredFieldCheck(userId,new LoginValidationException());
        requiredFieldCheck(userPw ,new LoginValidationException());
    }
}
