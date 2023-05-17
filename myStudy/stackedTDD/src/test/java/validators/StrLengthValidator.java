package validators;

public interface StrLengthValidator {
    default void strLengthCheck(String str, int min, int max, RuntimeException e) {
        if (min > 0 && (str==null || str.length() < min)) {
            throw  e;
        }
        if (max > 0 && (str==null || str.length() > max)) {
            throw e;
        }
    }

    default void strLengthCheck(String str, int min, RuntimeException e) {
        strLengthCheck(str, min, 0, e);
    }
}
