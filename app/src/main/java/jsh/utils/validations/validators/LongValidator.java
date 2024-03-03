package jsh.utils.validations.validators;

import java.util.Objects;
import jsh.utils.exceptions.NonNaturalNumberException;
import jsh.utils.exceptions.NonPositiveNumberException;

public class LongValidator {
    private LongValidator() {}

    /**
     * Checks {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the long to validate
     * @return {@code true} when n is a positive number, {@code false} otherwise
     */
    public static boolean isPositive(final long n) {
        return n >= 0;
    }

    /**
     * Checks {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the long to validate
     * @return {@code true} when n is a natural number, {@code false} otherwise
     */
    public static boolean isNatural(final long n) {
        return n > 0;
    }

    /**
     * Validates {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the long to validate
     * @param message message for an error thrown when {@code n} is not a positive number
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.utils.validations.ValidationUtil#requirePositiveNumber(long, String)
     * @see jsh.utils.validations.validators.LongValidator#requireNaturalNumber(long, String)
     */
    public static long requirePositiveNumber(final long n, final String message) {
        if (isPositive(n)) {
            return n;
        }
        throw Objects.isNull(message) ? new NonPositiveNumberException()
                : new NonNaturalNumberException(message);
    }

    /**
     * Validates {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the long to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.utils.validations.ValidationUtil#requirePositiveNumber(long)
     * @see jsh.utils.validations.validators.LongValidator#requireNaturalNumber(long)
     */
    public static long requirePositiveNumber(final long n) {
        return requirePositiveNumber(n, null);
    }

    /**
     * Validates {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the long to validate
     * @param message the message for the error thrown when {@code n} is not a natural number
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.utils.validations.ValidationUtil#requireNaturalNumber(long, String)
     * @see jsh.utils.validations.validators.LongValidator#requirePositiveNumber(long, String)
     */
    public static long requireNaturalNumber(final long n, final String message) {
        if (isNatural(n)) {
            return n;
        }
        throw Objects.isNull(message) ? new NonNaturalNumberException()
                : new NonNaturalNumberException(message);
    }

    /**
     * Validates {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the long to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.utils.validations.ValidationUtil#requireNaturalNumber(long)
     * @see jsh.utils.validations.validators.LongValidator#requirePositiveNumber(long)
     */
    public static long requireNaturalNumber(final long n) {
        return requireNaturalNumber(n, null);
    }

}
