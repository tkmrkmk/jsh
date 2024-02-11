package jsh.utils.exceptions;

/**
 * Thrown to indicate that a method has been passed is non-positive number as an argument while
 * expecting positive number.
 */
public class NonPositiveNumberException extends IllegalArgumentException {
    public NonPositiveNumberException() {
        super();
    }

    public NonPositiveNumberException(String message) {
        super(message);
    }

    public NonPositiveNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonPositiveNumberException(Throwable cause) {
        super(cause);
    }
}
