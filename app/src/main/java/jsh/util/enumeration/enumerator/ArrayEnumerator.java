package jsh.util.enumeration.enumerator;

import jakarta.annotation.Nonnull;
import jsh.util.enumeration.Enumeration;

public final class ArrayEnumerator<E> implements Enumerator<E> {
    private final int lastIndex;
    private int cursor;
    @Nonnull private final E[] array;

    public ArrayEnumerator(final E[] array) {
        this.cursor = -1;
        this.array = array;
        this.lastIndex = array.length - 1;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < lastIndex;
    }

    @Override
    @Nonnull
    public Enumeration<E> next() {
        ++this.cursor;
        return new Enumeration<>(this.cursor, array[cursor]);
    }
}
