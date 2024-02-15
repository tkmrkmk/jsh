package jsh.utils.randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import jsh.utils.validations.ValidationUtil;

public class RandomCollectionGenerator {
    public static final <T> List<T> createListOf(final int size, final Supplier<T> supplier) {
        return RandomCollectionGenerator.createListOf(size, supplier, ArrayList::new);
    }

    public static final <T> List<T> createListOf(final int size, final Supplier<T> supplier,
            final Supplier<List<T>> listSupplier) {
        ValidationUtil.requireNaturalNumber(size);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(listSupplier);

        final List<T> list = listSupplier.get();
        for (int i = 0; i < size; i++) {
            list.set(i, supplier.get());
        }
        return list;
    }

    public static final <T> Set<T> createSetOf(final int size, final Supplier<T> supplier) {
        return createSetOf(size, supplier, HashSet::new);
    }

    public static final <T> Set<T> createSetOf(final int size, final Supplier<T> supplier,
            final Supplier<Set<T>> setSupplier) {
        ValidationUtil.requireNaturalNumber(size);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(setSupplier);

        final Set<T> set = setSupplier.get();
        for (int i = 0; i < size; i++) {
            set.add(supplier.get());
        }
        return set;
    }

    public static final <T> Collection<T> createCollectionOf(final int size, final Supplier<T> supplier,
            final Supplier<Collection<T>> collectionSupplier) {
        ValidationUtil.requireNaturalNumber(size);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(collectionSupplier);

        final Collection<T> collection = collectionSupplier.get();
        for (int i = 0; i < size; i++) {
            collection.add(supplier.get());
        }
        return collection;
    }
}
