package jsh.constants;

import java.util.Set;
import jsh.util.random.RandomUtil;
import lombok.Getter;

public final class FruitAdjectives {
    @Getter(lazy = true)
    private static final Set<String> values = Set.of("cheap", "common", "fresh", "huge", "bitter",
            "ripe", "rotten", "hard", "soft", "unripe", "smashed", "juiced", "heavy", "bland",
            "cut", "juicy", "pricy", "rich", "sweet", "healthy", "tiny", "small", "watery");

    public static String getRandom() {
        return RandomUtil.pickRandom(getValues());
    }
}
