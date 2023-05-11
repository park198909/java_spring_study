package validators;

public interface RequiredDataValidator {
    default void requiredDataCheck(String str, RuntimeException e) {
        if (str==null || str.isBlank()) {
            throw e;
        }
    }
}
