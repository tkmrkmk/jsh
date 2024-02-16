package jsh.utils.validations;

import java.util.Objects;

public class ValidationError {
    public final String name;
    public final String description;

    public ValidationError(final String name, final String description) {
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        if (name.isBlank()) {
            throw new IllegalArgumentException("Provide name.");
        }
    }
}
