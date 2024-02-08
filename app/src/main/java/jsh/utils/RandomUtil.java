package jsh.utils;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtil {
    private RandomUtil() {
    }

    public static <T> T pickRandom(Set<T> set) {
        return pickRandom(set, ThreadLocalRandom.current());
    }

    public static <T> T pickRandom(Set<T> set, Random random) {
        final int i = random.nextInt(set.size());
        int c = 0;
        for (T e : set) {
            if (c++ == i) {
                return e;
            }
        }
        throw new RuntimeException("Something went wrong while randomly picking one from set.");
    }
}
