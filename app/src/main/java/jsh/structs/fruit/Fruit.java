package jsh.structs.fruit;

import jsh.structs.item.Item;
import lombok.Getter;

@Getter
public class Fruit extends Item {
    protected String[] adjectives;

    public Fruit(final int price, final String name) {
        super(price, name);
        this.adjectives = new String[0];
    }

    public Fruit(final int price, final String name, final String[] adjectives) {
        super(price, name);
        this.adjectives = adjectives;
    }
}
