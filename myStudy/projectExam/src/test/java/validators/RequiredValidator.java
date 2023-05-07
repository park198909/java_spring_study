package validators;

public interface RequiredValidator {
    default void requiredCheck(String value, RuntimeException e) {
        if(value == null || value.isBlank()) {
            throw e;
        }
    }
}
