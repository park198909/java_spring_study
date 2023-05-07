package validator;

public interface RequiredValidator {
    default void requiredFieldCheck(String value, RuntimeException e) {
        if(value == null || value.isBlank()) {
            throw e;
        }
    }
}
