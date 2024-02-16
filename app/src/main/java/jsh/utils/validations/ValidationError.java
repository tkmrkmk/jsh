package jsh.utils.validations;

import java.util.Objects;

public class ValidationError {
    public final String name;
    public final String description;

    public ValidationError(final String name, final String description) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
        if (name.isBlank()) {
            throw new IllegalArgumentException("Provide name.");
        }
        this.name = name;
        this.description = description;
    }
}
