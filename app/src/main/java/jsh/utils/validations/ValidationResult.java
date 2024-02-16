package jsh.utils.validations;

import java.util.List;

public class ValidationResult {
    public final boolean result;
    public final List<ValidationError> errors;

    ValidationResult(final boolean result, final List<ValidationError> errors) {
        this.result = result;
        this.errors = List.copyOf(errors);
    }

    ValidationResult(final boolean result, final ValidationError... errors) {
        this(result, List.of(errors));
    }

    ValidationResult(final boolean result, final ValidationError errors) {
        this(result, List.of(errors));
    }

    public final boolean isOk() {
        return this.result;
    }

    public final boolean isNg() {
        return !this.result;
    }
}
