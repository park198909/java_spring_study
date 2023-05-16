package validators;

public interface DataLengthValidator {
    default void dataLengthCheck(String str, int min, int max, RuntimeException e) {
        if (min>0 && (str==null || str.length() < min)) throw e;
        if (max>0 && (str==null || str.length() > max)) throw e;
    }

    default void dataLengthCheck(String str, int min, RuntimeException e) {
        dataLengthCheck(str, min, 0, e);
    }

}
