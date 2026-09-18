package jsh.util.enumeration.enumerator;

import java.util.Iterator;
import jsh.util.enumeration.Enumeration;

public sealed interface Enumerator<E> extends Iterator<Enumeration<E>>
        permits ListEnumerator, CollectionEnumerator, ArrayEnumerator {
    Enumeration<E> get() throws IndexOutOfBoundsException;
}
