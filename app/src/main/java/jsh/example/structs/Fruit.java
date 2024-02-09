package jsh.example.structs;

import lombok.Getter;

@Getter
public class Fruit extends Item {
    protected String[] adjectives;

    public Fruit(int price, String name) {
        super(price, name);
        this.adjectives = new String[0];
    }

    public Fruit(int price, String name, String[] adjectives) {
        super(price, name);
        this.adjectives = adjectives;
    }
}
