package exam02.validators;

public interface Validator<T> extends RequiredValidator, LengthCheckValidator {
    void check(T t);
}
