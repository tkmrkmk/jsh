package jsh.utils.randoms;

import java.util.Collection;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtil {
    private RandomUtil() {}

    public static <T> T pickRandom(final Set<T> set) {
        return pickRandom(set, ThreadLocalRandom.current());
    }

    public static <T> T pickRandom(final Collection<T> collection, final Random random) {
        final int ti = random.nextInt(collection.size());
        int i = 0;
        for (final T e : collection) {
            if (i++ == ti) {
                return e;
            }
        }
        throw new RuntimeException("Something went wrong while randomly picking one from set.");
    }

    public static <T> T pickRandom(final Collection<T> c) {
        return pickRandom(c, ThreadLocalRandom.current());
    }
}
