package jsh.util.enumeration;

import org.jspecify.annotations.Nullable;

public class Enumeration<E> {
    public final int index;
    @Nullable public final E element;

    public Enumeration(final int index, @Nullable final E element) {
        this.index = index;
        this.element = element;
    }
}
