package jsh.util.enumerator;

import java.util.Iterator;

public class EnumerableArray<E> implements Enumerable<E> {
    private final E[] array;

    public EnumerableArray(final E[] array) {
        this.array = array.clone();
    }

    @Override
    public Iterator<Enumeration<E>> iterator() {
        return new ArrayEnumerator();
    }

    class ArrayEnumerator implements Enumerator<E> {
        final int lastIndex;
        int cursor;

        ArrayEnumerator() {
            this.lastIndex = array.length - 1;
            this.cursor = -1;
        }

        @Override
        public boolean hasNext() {
            return this.cursor < lastIndex;
        }

        @Override
        public Enumeration<E> next() {
            ++this.cursor;
            return new Enumeration<>(this.cursor, array[cursor]);
        }
    }
}
