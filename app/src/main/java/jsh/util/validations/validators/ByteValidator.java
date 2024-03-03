package jsh.util.validations.validators;

import java.util.Objects;
import jsh.util.exception.NonNaturalNumberException;
import jsh.util.exception.NonPositiveNumberException;

public class ByteValidator {
    private ByteValidator() {}

    /**
     * Checks {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the byte to validate
     * @return {@code true} when n is a positive number, {@code false} otherwise
     */
    public static boolean isPositive(final byte n) {
        return n >= 0;
    }

    /**
     * Checks {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the byte to validate
     * @return {@code true} when n is a natural number, {@code false} otherwise
     */
    public static boolean isNatural(final byte n) {
        return n > 0;
    }

    /**
     * Validates {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the byte to validate
     * @param message message for an error thrown when {@code n} is not a positive number
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.util.validations.ValidationUtil#requirePositiveNumber(long, String)
     * @see jsh.util.validations.validators.ByteValidator#requireNaturalNumber(byte, String)
     */
    public static byte requirePositiveNumber(final byte n, final String message) {
        if (isPositive(n)) {
            return n;
        }
        throw Objects.isNull(message) ? new NonPositiveNumberException()
                : new NonNaturalNumberException(message);
    }

    /**
     * Validates {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the byte to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonPositiveNumberException when {@code n} is not a positive number
     * @see jsh.util.validations.ValidationUtil#requirePositiveNumber(long)
     * @see jsh.util.validations.validators.ByteValidator#requireNaturalNumber(byte)
     */
    public static byte requirePositiveNumber(final byte n) {
        return requirePositiveNumber(n, null);
    }

    /**
     * Validates {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the byte to validate
     * @param message the message for the error thrown when {@code n} is not a natural number
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.util.validations.ValidationUtil#requireNaturalNumber(long, String)
     * @see jsh.util.validations.validators.ByteValidator#requirePositiveNumber(byte, String)
     */
    public static byte requireNaturalNumber(final byte n, final String message) {
        if (isNatural(n)) {
            return n;
        }
        throw Objects.isNull(message) ? new NonNaturalNumberException()
                : new NonNaturalNumberException(message);
    }

    /**
     * Validates {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the byte to validate
     * @return the validated number (i.e. {@code n} itself)
     * @throws NonNaturalNumberException when {@code n} is not a natural number
     * @see jsh.util.validations.ValidationUtil#requireNaturalNumber(long)
     * @see jsh.util.validations.validators.ByteValidator#requirePositiveNumber(byte)
     */
    public static byte requireNaturalNumber(final byte n) {
        return requireNaturalNumber(n, null);
    }
}
