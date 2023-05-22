package com.study.validators;

public interface RequiredValidator {
    default void requiredFieldCheck(String str, RuntimeException e) {
        if (str==null || str.isBlank()) {
            throw e;
        }
    }
}
