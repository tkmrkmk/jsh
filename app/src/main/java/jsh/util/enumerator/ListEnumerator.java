package jsh.util.enumerator;

import java.util.List;
import java.util.stream.Stream;

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
    public EnumerationEntry<E> next() {
        ++this.cursor;
        return new EnumerationEntry<>(cursor, this.list.get(cursor));
    }

    @Override
    public Stream<EnumerationEntry<E>> stream() {
        final Stream.Builder<EnumerationEntry<E>> builder = Stream.builder();
        for (int c = 0; c < list.size(); ++c) {
            builder.accept(new EnumerationEntry<>(c, list.get(c)));
        }
        return builder.build();
    }
}
