package validators;

public interface LengthValidator {
    default void lengthCheck(String str, int min, int max, RuntimeException e) {
        if (max > 0 && (str==null || str.length() > max)) {
            throw e;
        }
        if (min > 0 && (str==null || str.length() < min)) {
            throw e;
        }
    }
    default  void lengthCheck(String str, int min, RuntimeException e) {
        lengthCheck(str, min,0, e);
    }
}
