package jsh.util.debugging;

import java.util.List;
import java.util.function.Function;
import jsh.struct.fruit.Fruit;
import jsh.struct.fruit.RandomFruitFactory;
import jsh.util.random.PositiveNumberRandom;

public class DebuggingUtilExample {
    private static RandomFruitFactory factory = new RandomFruitFactory();

    public static void main(final String[] args) {
        final List<Fruit> fruits = new DebuggingArrayList<>();
        final var pnr = PositiveNumberRandom.of(1, 3);

        for (int i = 0; i < 10; i++) {
            fruits.add(factory.generateRandom(pnr.nextInt()));
        }

        for (final var fruit : fruits) {
            System.out.println(DebuggingUtil.stringifyObject(fruitStringConverter, fruit));
        }
    }

    private static final Function<Fruit, String> fruitStringConverter = f -> {
        final StringBuilder sb = new StringBuilder();
        sb.append("- ");

        createAdjectivesString(sb, f);
        sb.append(f.getName());
        return sb.toString();
    };

    private static final void createAdjectivesString(final StringBuilder sb, final Fruit f) {
        final List<String> adjectives = f.getAdjectives();

        for (int i = 0, len = adjectives.size(); i < len; ++i) {
            final String a = adjectives.get(i);
            if (i != 0 && i + 1 >= len) {
                sb.append("and ").append(a).append(" ");
                return;
            }
            if (i + 1 >= len) {
                sb.append(a).append(" ");
                return;
            }
            sb.append(a).append(", ");
        }
        return;
    }
}
