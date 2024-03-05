package jsh.util.enumerator;

import java.util.ArrayList;
import java.util.Iterator;

public class EnumerableArray<E> implements Enumerable<E> {
    private final E[] array;

    public EnumerableArray(final E[] array) {
        this.array = array.clone();
    }

    @Override
    public Iterator<Enumeration<E>> iterator() {
        final ArrayList<Enumeration<E>> list = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; ++i) {
            list.add(new Enumeration<>(i, array[i]));
        }
        return list.iterator();
    }
}
