package jsh.util.validation.validator;

import jakarta.annotation.Nullable;
import jsh.util.exception.NonNaturalNumberException;
import jsh.util.exception.NonPositiveNumberException;

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
     * @see jsh.util.validation.ValidationUtil#requirePositiveNumber(long, String)
     * @see jsh.util.validation.validator.IntValidator#requireNaturalNumber(int, String)
     */
    public static int requirePositiveNumber(final int n, @Nullable final String message) {
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
     * @param n the integer to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.util.validation.ValidationUtil#requirePositiveNumber(long)
     * @see jsh.util.validation.validator.IntValidator#requireNaturalNumber(int)
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
     * @see jsh.util.validation.ValidationUtil#requireNaturalNumber(long, String)
     * @see jsh.util.validation.validator.IntValidator#requirePositiveNumber(int, String)
     */
    public static int requireNaturalNumber(final int n, @Nullable final String message) {
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
     * @param n the integer to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.util.validation.ValidationUtil#requireNaturalNumber(long)
     * @see jsh.util.validation.validator.IntValidator#requirePositiveNumber(int)
     */
    public static int requireNaturalNumber(final int n) {
        return requireNaturalNumber(n, null);
    }

    /**
     * Converts nullable Integer to int.
     *
     * @param i an integer
     * @return {@code i.intValue()} if {@code i} is not null, otherwise {@code 0}.
     */
    public static int toValueInt(@Nullable final Integer i) {
        if (i == null) {
            return 0;
        }
        return i.intValue();
    }
}
