package validators;

public interface Validator<T> extends RequiredCheckValidator, StrLengthValidator {
    void check(T t);
}
