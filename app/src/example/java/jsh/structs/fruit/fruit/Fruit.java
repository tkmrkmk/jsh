package jsh.structs.fruit.fruit;

import java.util.List;
import jsh.structs.item.Item;
import lombok.Getter;

@Getter
public class Fruit extends Item {
    protected List<String> adjectives;

    public Fruit(final int price, final String name) {
        super(price, name);
        this.adjectives = List.of();
    }

    public Fruit(final int price, final String name, final List<String> adjectives) {
        super(price, name);
        this.adjectives = adjectives;
    }
}
