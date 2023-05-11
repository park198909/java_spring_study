package validators;

public interface LengthDataValidator {
    default void lengthDataCheck(String str, int min, int max, RuntimeException e) {
        if (min > 0 && (str == null || str.length() < min)) {
           throw e;
        }
        if (max >0 && (str == null || str.length() > max)) {
           throw e;
        }
    }

    default void lengthDataCheck(String str, int min, RuntimeException e) {
        lengthDataCheck(str, min, 0, e);
    }
}
