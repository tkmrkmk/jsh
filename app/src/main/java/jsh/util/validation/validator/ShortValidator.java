package jsh.util.validation.validator;

import jsh.util.exception.NonNaturalNumberException;
import jsh.util.exception.NonPositiveNumberException;

public class ShortValidator {
    private ShortValidator() {}

    public static boolean isPositive(final short n) {
        return n >= 0;
    }

    public static boolean isNatural(final short n) {
        return n > 0;
    }

    /**
     * Validates {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the short to validate
     * @param message message for an error thrown when {@code n} is not a positive number
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.util.validation.ValidationUtil#requirePositiveNumber(long, String)
     * @see jsh.util.validation.validator.ShortValidator#requireNaturalNumber(short, String)
     */
    public static short requirePositiveNumber(final short n, final String message) {
        if (isPositive(n)) {
            return n;
        }
        throw message == null
                ? new NonPositiveNumberException()
                : new NonPositiveNumberException(message);
    }

    /**
     * Validates {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the short to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.util.validation.ValidationUtil#requirePositiveNumber(long)
     * @see jsh.util.validation.validator.ShortValidator#requireNaturalNumber(short)
     */
    public static short requirePositiveNumber(final short n) {
        return requirePositiveNumber(n, null);
    }

    /**
     * Validates {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the short to validate
     * @param message the message for the error thrown when {@code n} is not a natural number
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.util.validation.ValidationUtil#requireNaturalNumber(long, String)
     * @see jsh.util.validation.validator.ShortValidator#requirePositiveNumber(short, String)
     */
    public static short requireNaturalNumber(final short n, final String message) {
        if (isNatural(n)) {
            return n;
        }
        throw message == null
                ? new NonNaturalNumberException()
                : new NonNaturalNumberException(message);
    }

    /**
     * Validates {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the short to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.util.validation.ValidationUtil#requireNaturalNumber(long)
     * @see jsh.util.validation.validator.ShortValidator#requirePositiveNumber(short)
     */
    public static short requireNaturalNumber(final short n) {
        return requireNaturalNumber(n, null);
    }
}
