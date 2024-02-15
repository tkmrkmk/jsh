package jsh.utils.validations;

/** Validator interface. */
public interface Validator<T> {
    ValidationResult validate(T arg);
}
