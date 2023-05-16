package validators;

public interface RequiredCheckValidator {
    default void requiredFieldCheck(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
           throw e;
        }
    }

}
