package validator;

public interface DataLengthValidator {
    default void userIdLengthCheck(String userId, RuntimeException e) {
        if(userId.length() < 6 || userId.length() > 16) {
            throw e;
        }
    }

    default void userPwLengthCheck(String userPw, RuntimeException e) {
        if(userPw.length() < 8) {
            throw e;
        }
    }
}
