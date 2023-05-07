package validators;

public interface Validator<T> extends StrLengthValidator, RequiredValidator {
    void check(T t);
}
