package jsh.structs.fruit;

import java.util.ArrayList;
import java.util.List;
import jsh.constants.FruitAdjectives;
import jsh.constants.FruitNames;
import jsh.util.random.PositiveNumberRandom;
import jsh.util.validation.validator.IntValidator;
import lombok.NonNull;

public class RandomFruitFactory {
    public final PositiveNumberRandom random;

    public RandomFruitFactory() {
        this.random = PositiveNumberRandom.of(100, 10000);
    }

    public RandomFruitFactory(@NonNull final PositiveNumberRandom random) {
        this.random = random;
    }

    public final List<String> generateRandomAdjectives(final int size) {
        IntValidator.requireNaturalNumber(size);

        final List<String> list = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            list.add(FruitAdjectives.getRandom());
        }
        return list;
    }

    public final Fruit generateRandom(final int adjectiveNum) {
        IntValidator.requireNaturalNumber(adjectiveNum,
                "Negative number for adjectives doesn't make any sense!");
        if (adjectiveNum == 0) {
            return new Fruit(random.nextInt(), FruitNames.getRandom());
        }
        return new Fruit(random.nextInt(), FruitNames.getRandom(),
                generateRandomAdjectives(adjectiveNum));
    }
}
