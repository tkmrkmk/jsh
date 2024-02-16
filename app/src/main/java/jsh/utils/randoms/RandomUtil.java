package jsh.utils.randoms;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtil {
    private RandomUtil() {}

    public static <T> T pickRandom(final List<T> list, final Random random) {
        return list.get(random.nextInt(list.size()));
    }

    public static <T> T pickRandom(final List<T> list) {
        return pickRandom(list, ThreadLocalRandom.current());
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
