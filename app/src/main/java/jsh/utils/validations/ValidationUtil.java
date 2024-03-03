package jsh.utils.validations;

import java.util.Objects;

public final class ValidationUtil {
    private ValidationUtil() {}

    public static void validateNonNulls(final Object... os) {
        for (final var o : os) {
            Objects.requireNonNull(o);
        }
    }
}
