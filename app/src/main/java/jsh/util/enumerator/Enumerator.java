package jsh.util.enumerator;

import java.util.Iterator;
import java.util.stream.Stream;

public interface Enumerator<E> extends Iterator<Enumeration<E>> {
    Stream<Enumeration<E>> stream();
}
