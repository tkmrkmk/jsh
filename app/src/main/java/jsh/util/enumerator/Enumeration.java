package jsh.util.enumerator;

import jakarta.annotation.Nonnull;

public class Enumeration<E> {
    public final int index;
    public final E element;

    public Enumeration(final int index, @Nonnull final E element) {
        this.index = index;
        this.element = element;
    }
}
