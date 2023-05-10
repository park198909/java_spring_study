package models.member;

public class ExistIdValidationException extends RuntimeException {
    public ExistIdValidationException() {
        super("미등록된 아이디 입니다.");
    }
}
