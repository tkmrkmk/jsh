package jsh.util.iterator;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private final E[] array;
    private final int lastIndex;
    private int cursor;

    public ArrayIterator(final E[] array) {
        this.array = array;
        this.lastIndex = array.length - 1;
        this.cursor = -1;
    }

    @Override
    public boolean hasNext() {
        return cursor < lastIndex;
    }

    @Override
    public E next() {
        ++cursor;
        return array[cursor];
    }

    public boolean isLast() {
        return cursor == lastIndex;
    }

    public boolean isFirst() {
        return cursor == 0;
    }
}
