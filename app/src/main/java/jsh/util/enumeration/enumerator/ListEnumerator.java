package jsh.util.enumeration.enumerator;

import java.util.List;
import java.util.Objects;
import jakarta.annotation.Nonnull;
import jsh.util.enumeration.Enumeration;

public class ListEnumerator<E> implements Enumerator<E> {
    @Nonnull private final List<E> list;
    private final int lastIndex;
    private int cursor;

    public ListEnumerator(@Nonnull final List<E> list) {
        this.list = Objects.requireNonNull(List.copyOf(list));
        this.lastIndex = list.size() - 1;
        this.cursor = -1;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < this.lastIndex;
    }

    @Override
    @Nonnull
    public Enumeration<E> next() {
        ++this.cursor;
        return new Enumeration<>(this.cursor, this.list.get(cursor));
    }
}
