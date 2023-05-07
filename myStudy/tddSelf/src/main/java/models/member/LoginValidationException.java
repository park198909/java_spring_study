package models.member;

public class LoginValidationException extends RuntimeException {
    public LoginValidationException() {
        super("잘못된 아이디이거나 비밀번호가 틀립니다.");
    }
}
