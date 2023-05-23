package org.koreait.validators;

public interface Validator<T> extends RequireFieldValidator {
    void check(T t);
}
