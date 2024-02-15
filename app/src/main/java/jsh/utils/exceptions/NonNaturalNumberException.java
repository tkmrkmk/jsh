package jsh.utils.exceptions;

/**
 * Thrown to indicate that a method has been passed is non-natural number as an argument while
 * expecting natural number.
 */
public class NonNaturalNumberException extends IllegalArgumentException {
    public NonNaturalNumberException() {
        super();
    }

    public NonNaturalNumberException(final String message) {
        super(message);
    }

    public NonNaturalNumberException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NonNaturalNumberException(final Throwable cause) {
        super(cause);
    }
}
