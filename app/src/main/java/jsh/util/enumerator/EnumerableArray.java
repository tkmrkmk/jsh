package jsh.util.enumerator;

import java.util.Arrays;
import java.util.Objects;
import jakarta.annotation.Nonnull;

public class EnumerableArray<E> implements Enumerable<E> {
    @Nonnull private final E[] array;

    public EnumerableArray(@Nonnull final E[] array) {
        this.array = Objects.requireNonNull(Arrays.copyOf(array, array.length));
    }

    @Override
    @Nonnull
    public Enumerator<E> iterator() {
        return new ArrayEnumerator();
    }

    private final class ArrayEnumerator implements Enumerator<E> {
        private final int lastIndex;
        private int cursor;

        private ArrayEnumerator() {
            this.cursor = -1;
            this.lastIndex = EnumerableArray.this.array.length - 1;
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
}
