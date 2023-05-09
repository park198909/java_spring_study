package models.member;

public class ExistValidationException extends RuntimeException{
    public ExistValidationException() {
        super("이미 가입된 아이디 입니다.");
    }
}
