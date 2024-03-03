package jsh.structs.fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import jsh.constants.FruitAdjectives;
import jsh.constants.FruitNames;
import jsh.utils.validations.ValidationUtil;

public class RandomFruitFactory {
    public final Random random;

    public RandomFruitFactory() {
        this.random = ThreadLocalRandom.current();
    }

    public RandomFruitFactory(final Random random) {
        this.random = random;
    }

    public final List<String> generateRandomAdjectives(final int size) {
        ValidationUtil.requireNaturalNumber(size);

        final List<String> list = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            list.add(FruitAdjectives.getRandom());
        }
        return list;
    }

    public final Fruit generateRandom(final int adjectiveNum) {
        return generateRandom(ThreadLocalRandom.current(), adjectiveNum);
    }

    public final Fruit generateRandom(final Random r, final int adjectiveNum) {
        ValidationUtil.requireNaturalNumber(adjectiveNum,
                "Negative number for adjectives doesn't make any sense!");
        if (adjectiveNum == 0) {
            return new Fruit(r.nextInt(1000) + 101, FruitNames.getRandom());
        }
        return new Fruit(r.nextInt(1000) + 101, FruitNames.getRandom(),
                generateRandomAdjectives(adjectiveNum));
    }
}
