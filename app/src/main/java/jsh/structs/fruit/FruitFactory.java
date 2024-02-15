package jsh.structs.fruit;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import jsh.constants.FruitAdjectives;
import jsh.constants.FruitNames;
import jsh.utils.validations.ValidationUtil;

public class FruitFactory {
    public static final String[] generateRandomAdjectives(final int size) {
        ValidationUtil.requireNaturalNumber(size);

        final String[] array = new String[size];
        for (int i = 0; i < size; ++i) {
            array[i] = FruitAdjectives.getRandom();
        }
        return array;
    }

    public static final Fruit generateRandom(final int adjectiveNum) {
        return generateRandom(ThreadLocalRandom.current(), adjectiveNum);
    }

    public static final Fruit generateRandom(final Random r, final int adjectiveNum) {
        ValidationUtil.requireNaturalNumber(adjectiveNum,
                "Negative number for adjectives doesn't make any sense!");
        if (adjectiveNum == 0) {
            return new Fruit(r.nextInt(1000) + 101, FruitNames.getRandom());
        }
        return new Fruit(r.nextInt(1000) + 101, FruitNames.getRandom(),
                generateRandomAdjectives(adjectiveNum));
    }
}
