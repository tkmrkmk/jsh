package jsh.constants;

import java.util.Set;
import jsh.utils.RandomUtil;
import lombok.Getter;

public class FruitNames {
    @Getter(lazy = true)
    private static final Set<String> values = Set.of("apple", "apricot", "banana", "blueberry",
            "blackberry", "cantaloupe", "cherry", "dragongfruit", "fig", "grape", "grapefruit",
            "guava", "huckleberry", "jujube", "kiwifruit", "lemon", "lime", "mango", "melon",
            "orange", "papaya", "peach", "pineapple", "plum", "pomegranate", "strawberry",
            "tangerine", "raspberry", "persimmon", "cranberry", "lychee", "tomato", "watermelon");

    public static String getRandom() {
        return RandomUtil.pickRandom(getValues());
    }
}
