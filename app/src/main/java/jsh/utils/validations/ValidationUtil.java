package jsh.utils.validations;

import java.util.Objects;
import jsh.utils.exceptions.NonNaturalNumberException;
import jsh.utils.exceptions.NonPositiveNumberException;

public final class ValidationUtil {
    private ValidationUtil() {}

    public static void validateNonNulls(final Object... os) {
        for (final var o : os) {
            Objects.requireNonNull(o);
        }
    }

    /**
     * Validate {@code n} is a positive number (i.e. {@code n} &gt;= 0).
     *
     * @param n the number to validate.
     * @param message message for an error thrown when {@code n} is not a positive number.
     * @return the validated number.
     * @throws NonNaturalNumberException when {@code n} is not a natural number.
     */
    public static long requireNaturalNumber(final long n, final String message) {
        if (n > 0) {
            return n;
        }
        throw new NonNaturalNumberException(message);
    }

    /**
     * Validate {@code n} is a natural number (i.e. {@code n} &gt; 0).
     *
     * @param n the number to validate.
     * @return the validated number.
     * @throws NonNaturalNumberException when {@code n} is not a natural number.
     */
    public static long requireNaturalNumber(final long n) {
        if (n > 0) {
            return n;
        }
        throw new NonNaturalNumberException();
    }

    /**
     * Validate {@code n} is a positive number (including 0).
     *
     * @param n the number to validate.
     * @return the validated number.
     * @throws NonPositiveNumberException when {@code n} is not a positive number.
     */
    public static long requirePositiveNumber(final long n, final String message) {
        if (n >= 0) {
            return n;
        }
        throw new NonPositiveNumberException(message);
    }

    /**
     * Validate {@code n} is a positive number (including 0).
     *
     * @param n the number to validate.
     * @param message message for an error thrown when {@code n} is not a positive number.
     * @return the validated number.
     * @throws NonPositiveNumberException when {@code n} is not a positive number.
     */
    public static long requirePositiveNumber(final long n) {
        if (n >= 0) {
            return n;
        }
        throw new NonPositiveNumberException();
    }

    // methods for other primitive types

    /**
     * Validate {@code n} is a positive number (including 0). c.f.
     * {@link jsh.utils.validations.ValidationUtil#requireNaturalNumber(long, String)}
     *
     * @param n the number to validate.
     * @param message message for an error thrown when {@code n} is not a positive number.
     * @return the validated number.
     * @throws NonNaturalNumberException when {@code n} is not a natural number.
     */
    public static short requireNaturalNumber(final short n, final String message) {
        return (short) requireNaturalNumber((long) n, message);
    }

    /**
     * Validate {@code n} is a positive number (including 0). c.f.
     * {@link jsh.utils.validations.ValidationUtil#requireNaturalNumber(long, String)}
     *
     * @param n the number to validate.
     * @param message message for an error thrown when {@code n} is not a positive number.
     * @return the validated number.
     * @throws NonNaturalNumberException when {@code n} is not a natural number.
     */
    public static byte requireNaturalNumber(final byte n, final String message) {
        return (byte) requireNaturalNumber((long) n, message);
    }

    /**
     * Validate {@code n} is a positive number (including 0). c.f.
     * {@link jsh.utils.validations.ValidationUtil#requireNaturalNumber(long, String)}
     *
     * @param n the number to validate.
     * @return the validated number.
     * @throws NonNaturalNumberException when {@code n} is not a natural number.
     */
    public static short requireNaturalNumber(final short n) {
        return (short) requireNaturalNumber((long) n);
    }

    /**
     * Validate {@code n} is a positive number (including 0). c.f.
     * {@link jsh.utils.validations.ValidationUtil#requireNaturalNumber(long, String)}
     *
     * @param n the number to validate.
     * @return the validated number.
     * @throws NonNaturalNumberException when {@code n} is not a natural number.
     */
    public static byte requireNaturalNumber(final byte n) {
        return (byte) requireNaturalNumber((long) n);
    }

    /**
     * c.f. {@link jsh.utils.validations.ValidationUtil#requirePositiveNumber(long, String)}.
     *
     * @param n the number to validate.
     * @param message message for an error thrown when {@code n} is not a positive number.
     * @return the validated number.
     * @throws NonPositiveNumberException when {@code n} is not a positive number.
     */
    public static short requirePositiveNumber(final short n, final String message) {
        return (short) requirePositiveNumber((long) n, message);
    }

    /**
     * c.f. {@link jsh.utils.validations.ValidationUtil#requirePositiveNumber(long, String)}.
     *
     * @param n the number to validate.
     * @param message message for an error thrown when {@code n} is not a positive number.
     * @return the validated number.
     * @throws NonPositiveNumberException when {@code n} is not a positive number.
     */
    public static byte requirePositiveNumber(final byte n, final String message) {
        return (byte) requirePositiveNumber((long) n, message);
    }

    /**
     * c.f. {@link jsh.utils.validations.ValidationUtil#requirePositiveNumber(long)}.
     *
     * @param n the number to validate.
     * @return the validated number.
     * @throws NonPositiveNumberException when {@code n} is not a positive number.
     */
    public static short requirePositiveNumber(final short n) {
        return (short) requirePositiveNumber((long) n);
    }

    /**
     * c.f. {@link jsh.utils.validations.ValidationUtil#requirePositiveNumber(long)}.
     *
     * @param n the number to validate.
     * @return the validated number.
     * @throws NonPositiveNumberException when {@code n} is not a positive number.
     */
    public static byte requirePositiveNumber(final byte n) {
        return (byte) requirePositiveNumber((long) n);
    }
}
