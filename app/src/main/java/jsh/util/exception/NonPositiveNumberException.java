package jsh.util.exception;

/**
 * Thrown to indicate that a method has been passed a non-positive number as an argument while
 * expecting positive number.
 */
public class NonPositiveNumberException extends IllegalArgumentException {
    public NonPositiveNumberException() {
        super();
    }

    public NonPositiveNumberException(final String message) {
        super(message);
    }

    public NonPositiveNumberException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NonPositiveNumberException(final Throwable cause) {
        super(cause);
    }
}
