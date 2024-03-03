package jsh.utils.validations.validators;

import java.util.Objects;
import jsh.utils.exceptions.NonNaturalNumberException;
import jsh.utils.exceptions.NonPositiveNumberException;

public class IntValidator {
    private IntValidator() {}

    /**
     * Checks {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the integer to validate
     * @return {@code true} when n is a positive number, {@code false} otherwise
     */
    public static boolean isPositive(final int n) {
        return n >= 0;
    }

    /**
     * Checks {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the integer to validate
     * @return {@code true} when n is a natural number, {@code false} otherwise
     */
    public static boolean isNatural(final int n) {
        return n > 0;
    }

    /**
     * Validates {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the integer to validate
     * @param message message for an error thrown when {@code n} is not a positive number
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.utils.validations.ValidationUtil#requirePositiveNumber(long, String)
     * @see jsh.utils.validations.validators.IntValidator#requireNaturalNumber(int, String)
     */
    public static int requirePositiveNumber(final int n, final String message) {
        if (isPositive(n)) {
            return n;
        }
        throw Objects.isNull(message) ? new NonPositiveNumberException()
                : new NonNaturalNumberException(message);
    }

    /**
     * Validates {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the integer to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.utils.validations.ValidationUtil#requirePositiveNumber(long)
     * @see jsh.utils.validations.validators.IntValidator#requireNaturalNumber(int)
     */
    public static int requirePositiveNumber(final int n) {
        return requirePositiveNumber(n, null);
    }

    /**
     * Validates {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the integer to validate
     * @param message the message for the error thrown when {@code n} is not a natural number
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.utils.validations.ValidationUtil#requireNaturalNumber(long, String)
     * @see jsh.utils.validations.validators.IntValidator#requirePositiveNumber(int, String)
     */
    public static int requireNaturalNumber(final int n, final String message) {
        if (isNatural(n)) {
            return n;
        }
        throw Objects.isNull(message) ? new NonNaturalNumberException()
                : new NonNaturalNumberException(message);
    }

    /**
     * Validates {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the integer to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.utils.validations.ValidationUtil#requireNaturalNumber(long)
     * @see jsh.utils.validations.validators.IntValidator#requirePositiveNumber(int)
     */
    public static int requireNaturalNumber(final int n) {
        return requireNaturalNumber(n, null);
    }
}
