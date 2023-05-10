package validators;

public interface Validator<T> extends RequiredValidator, LengthValidator, EmailFormValidator {
    void check(T t);
}
