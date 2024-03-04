package jsh.util.enumerator;

public class Enumeration<E> {
    public final int index;
    public final E element;

    public Enumeration(final int index, final E element) {
        this.index = index;
        this.element = element;
    }
}
