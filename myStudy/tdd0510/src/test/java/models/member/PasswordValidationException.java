package models.member;

public class PasswordValidationException extends RuntimeException {
    public PasswordValidationException() {
        super("아이디 또는 비밀번호를 확인하세요.");
    }
}
