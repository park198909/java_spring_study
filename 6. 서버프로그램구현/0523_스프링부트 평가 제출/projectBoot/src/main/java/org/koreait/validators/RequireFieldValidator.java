package org.koreait.validators;

public interface RequireFieldValidator {
    default void requiredFieldCheck(String str, RuntimeException e) {
        if (str==null || str.isBlank()) {
            throw e;
        }
    }
}
