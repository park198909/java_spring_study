package models.member;

public class DuplicateValidationException extends RuntimeException {
    public DuplicateValidationException() {
        super("이미 가입된 아이디입니다.");
    }
}
