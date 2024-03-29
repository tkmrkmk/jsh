package jsh.structs.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jsh.constants.FruitNames;
import jsh.utils.randoms.PositiveNumberRandom;
import lombok.NonNull;

public class ItemFactory {
    private final PositiveNumberRandom random;

    public ItemFactory() {
        this.random = PositiveNumberRandom.getDefault();
    }

    public ItemFactory(@NonNull final PositiveNumberRandom cr) {
        Objects.requireNonNull(cr);
        this.random = cr;
    }

    public final Item generateRandom() {
        return new Item(this.random.nextInt(), FruitNames.getRandom());
    }

    public final List<Item> generateRandoms(final int size) {
        final var list = new ArrayList<Item>(size);
        for (int i = 0; i < size; ++i) {
            list.add(this.generateRandom());
        }
        return list;
    }
}
