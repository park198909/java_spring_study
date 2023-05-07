package validator;

public interface Validator<T> extends RequiredValidator, DataLengthValidator, DuplicatedValidator {
    void check(T t);
}
