package models.member;

public class loginValidationException extends RuntimeException{
    public loginValidationException(String message) {
        super(message);
    }
}
