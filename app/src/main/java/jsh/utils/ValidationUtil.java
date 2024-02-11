package jsh.utils;

import jsh.utils.exceptions.NonNaturalNumberException;

public final class ValidationUtil {
    private ValidationUtil() {}

    public static long requireNaturalNumber(final long n, final String message) {
        if (n > 0) {
            return n;
        }
        throw new NonNaturalNumberException(message);
    }

    public static long requireNaturalNumber(final long n) {
        if (n > 0) {
            return n;
        }
        throw new NonNaturalNumberException();
    }

    // methods for other primitive types

    public static int requireNaturalNumber(final int n, final String message) {
        return (int) requireNaturalNumber((long) n, message);
    }

    public static short requireNaturalNumber(final short n, final String message) {
        return (short) requireNaturalNumber((long) n, message);
    }

    public static byte requireNaturalNumber(final byte n, final String message) {
        return (byte) requireNaturalNumber((long) n, message);
    }

    public static int requireNaturalNumber(final int n) {
        return (int) requireNaturalNumber((long) n);
    }

    public static short requireNaturalNumber(final short n) {
        return (short) requireNaturalNumber((long) n);
    }

    public static byte requireNaturalNumber(final byte n) {
        return (byte) requireNaturalNumber((long) n);
    }

    private static boolean isNaturalNumber(final long n) {
        return n > 0;
    }
}
