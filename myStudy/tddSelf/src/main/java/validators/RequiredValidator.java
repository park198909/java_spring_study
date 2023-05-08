package validators;

public interface RequiredValidator {
    default void requiredFieldTest(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
           throw  e;
        }
    }
}
