package jsh.util.validation;

import java.util.Objects;
import jakarta.annotation.Nonnull;

public final class ValidationUtil {
    private ValidationUtil() {}

    public static void validateNonNulls(@Nonnull final Object... os) {
        Objects.requireNonNull(os);
        for (final var o : os) {
            Objects.requireNonNull(o);
        }
    }
}
