package jsh.util.enumerator;

import java.util.stream.Stream;

public class ArrayEnumerator<E> implements Enumerator<E> {
    final E[] array;
    final int lastIndex;
    private int cursor;

    public ArrayEnumerator(final E[] array) {
        this.array = array.clone();
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
        return new Enumeration<>(cursor, this.array[cursor]);
    }

    @Override
    public Stream<Enumeration<E>> stream() {
        final Stream.Builder<Enumeration<E>> builder = Stream.builder();
        for (int c = 0; c < array.length; ++c) {
            builder.accept(new Enumeration<>(c, array[c]));
        }
        return builder.build();
    }

    public boolean isFirst() {
        return this.cursor == 0;
    }

    public boolean isLast() {
        return this.cursor == lastIndex;
    }
}
