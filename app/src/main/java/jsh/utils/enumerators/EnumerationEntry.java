package jsh.utils.enumerators;

public class EnumerationEntry<E> {
    public final int index;
    public final E element;

    public EnumerationEntry(final int index, final E element) {
        this.index = index;
        this.element = element;
    }
}
