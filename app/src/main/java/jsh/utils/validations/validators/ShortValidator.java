package jsh.utils.validations.validators;

import java.util.Objects;
import jsh.utils.exceptions.NonNaturalNumberException;
import jsh.utils.exceptions.NonPositiveNumberException;

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
     * @see jsh.utils.validations.ValidationUtil#requirePositiveNumber(long, String)
     * @see jsh.utils.validations.validators.ShortValidator#requireNaturalNumber(short, String)
     */
    public static short requirePositiveNumber(final short n, final String message) {
        if (isPositive(n)) {
            return n;
        }
        throw Objects.isNull(message) ? new NonPositiveNumberException()
                : new NonNaturalNumberException(message);
    }

    /**
     * Validates {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the short to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.utils.validations.ValidationUtil#requirePositiveNumber(long)
     * @see jsh.utils.validations.validators.ShortValidator#requireNaturalNumber(short)
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
     * @see jsh.utils.validations.ValidationUtil#requireNaturalNumber(long, String)
     * @see jsh.utils.validations.validators.ShortValidator#requirePositiveNumber(short, String)
     */
    public static short requireNaturalNumber(final short n, final String message) {
        if (isNatural(n)) {
            return n;
        }
        throw Objects.isNull(message) ? new NonNaturalNumberException()
                : new NonNaturalNumberException(message);
    }

    /**
     * Validates {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the short to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.utils.validations.ValidationUtil#requireNaturalNumber(long)
     * @see jsh.utils.validations.validators.ShortValidator#requirePositiveNumber(short)
     */
    public static short requireNaturalNumber(final short n) {
        return requireNaturalNumber(n, null);
    }
}
