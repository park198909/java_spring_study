package validators;

public interface Validator<T> extends RequiredCheckValidator, DataLengthValidator, DataFormValidator {
    void check(T t);
}
