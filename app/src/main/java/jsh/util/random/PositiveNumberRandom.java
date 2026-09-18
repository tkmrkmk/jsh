package jsh.util.random;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import jsh.util.exception.NonPositiveNumberException;
import jsh.util.validation.validator.IntValidator;

/**
 * Utility for generating random positive integers under given conditions.
 */
public final class PositiveNumberRandom {
    public final int min;
    public final int max;
    public final Random random;
    private final int variation;

    private PositiveNumberRandom(final int min, final int max, final Random random) {
        this.min =
                IntValidator.requirePositiveNumber(min, "Min must be greater than or equal to 0.");
        this.max =
                IntValidator.requirePositiveNumber(max, "Max must be greater than or equal to 0.");
        if (max < min) {
            throw new IllegalArgumentException("Max must be greater than or equal to min.");
        }
        this.variation = max - min + 1;
        this.random = Objects.requireNonNull(random, "Random must not be null.");
    }

    /**
     * Create a pre-configured {@code Random} instance with these conditions:
     * <ul>
     * <li>min = 0</li>
     * <li>max = 100</li>
     * <li>random = ThreadLocalRandom.current()</li>
     * </ul>
     *
     * @return the configured {@code Random} instance with conditions stated.
     */
    public static final PositiveNumberRandom getDefault() {
        return new PositiveNumberRandom(0, 100, ThreadLocalRandom.current());
    }

    /**
     * Create a pre-configured {@code Random} instance with the given {@code Random} instance.
     *
     * @param min the minimum number (inclusive)
     * @param max the maximum number (inclusive unlike {@link java.util.Random#nextInt(int)})
     * @param random a {@code Random} instance to use
     * @return a pre-configured {@code Random} instance
     *
     * @throws IllegalArgumentException when {@code max} is less than {@code min}.
     * @throws NonPositiveNumberException when either {@code min} or {@code max} is less than or
     *         equal to 0.
     */
    public static final PositiveNumberRandom of(final int min, final int max, final Random random) {
        return new PositiveNumberRandom(min, max, random);
    }

    /**
     * Create a pre-configured {@code Random} instance with a {@code Random} instance created by
     * {@link java.util.concurrent.ThreadLocalRandom#current()}.
     *
     * @param min the minimum number (inclusive)
     * @param max the maximum number (inclusive unlike {@link java.util.Random#nextInt(int)})
     * @return a pre-configured {@code Random} instance
     *
     * @throws IllegalArgumentException when {@code max} is less than {@code min}.
     * @throws NonPositiveNumberException when either {@code min} or {@code max} is less than or
     *         equal to 0.
     */
    public static final PositiveNumberRandom of(final int min, final int max) {
        return new PositiveNumberRandom(min, max, ThreadLocalRandom.current());
    }

    public final int nextInt() {
        return this.min + this.random.nextInt(this.variation);
    }
}
