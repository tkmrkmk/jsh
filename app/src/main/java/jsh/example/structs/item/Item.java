package jsh.example.structs.item;

import java.util.Comparator;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class Item implements Comparable<Item> {
    protected int price;
    protected String name;

    public Item(int price, @NonNull final String name) {
        this.price = price;
        this.name = name;
    }

    public static final Comparator<Item> itemPriceComparator =
            (t, o) -> Integer.compare(t.price, o.price);
    public static final Comparator<Item> itemNameComparator = (t, o) -> t.name.compareTo(o.name);

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.name);
    }
}
