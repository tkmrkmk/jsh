package jsh.util.enumerator;

import java.util.List;

public class ListEnumerator<E> implements Enumerator<E> {
    final List<E> list;
    final int lastIndex;
    private int cursor;

    public ListEnumerator(final List<E> list) {
        this.list = List.copyOf(list);
        this.lastIndex = list.size() - 1;
        this.cursor = -1;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < lastIndex;
    }

    @Override
    public Enumeration<E> next() {
        ++this.cursor;
        return new Enumeration<>(cursor, this.list.get(cursor));
    }
}
