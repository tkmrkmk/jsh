package jsh.utils;

import java.util.Collection;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtil {
    private RandomUtil() {}

    public static <T> T pickRandom(Set<T> set) {
        return pickRandom(set, ThreadLocalRandom.current());
    }

    public static <T> T pickRandom(Collection<T> collection, final Random random) {
        final int ti = random.nextInt(collection.size());
        int i = 0;
        for (T e : collection) {
            if (i++ == ti) {
                return e;
            }
        }
        throw new RuntimeException("Something went wrong while randomly picking one from set.");
    }

    public static <T> T pickRandom(Collection<T> c) {
        return pickRandom(c, ThreadLocalRandom.current());
    }
}
