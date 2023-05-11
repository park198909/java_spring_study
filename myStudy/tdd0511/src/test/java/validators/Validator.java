package validators;

public interface Validator<T> extends RequiredDataValidator, LengthDataValidator, PasswordFormValidator {
    void check(T t);
}
