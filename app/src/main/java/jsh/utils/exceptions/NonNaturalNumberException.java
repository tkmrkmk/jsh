package jsh.utils.exceptions;

/**
 * Thrown to indicate that a method has been passed is non-natural number as an argument while
 * expecting natural number.
 */
public class NonNaturalNumberException extends IllegalArgumentException {
    public NonNaturalNumberException() {
        super();
    }

    public NonNaturalNumberException(String message) {
        super(message);
    }

    public NonNaturalNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonNaturalNumberException(Throwable cause) {
        super(cause);
    }
}
