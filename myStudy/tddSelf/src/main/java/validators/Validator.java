package validators;

public interface Validator<T> extends RequiredValidator, LengthValidator {
    void check(T t);
}
