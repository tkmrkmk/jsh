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
    public static final <T> List<T> createListOf(final int size,
            final Supplier<T> randomElementSupplier) {
        return RandomCollectionGenerator.createListOf(size, randomElementSupplier, ArrayList::new);
    }

    public static final <T> List<T> createListOf(final int size,
            final Supplier<T> randomElementSupplier, final Supplier<List<T>> listSupplier) {
        validateArgs(size, randomElementSupplier, listSupplier);

        final List<T> list = listSupplier.get();
        for (int i = 0; i < size; i++) {
            list.set(i, randomElementSupplier.get());
        }
        return list;
    }

    public static final <T> Set<T> createSetOf(final int size,
            final Supplier<T> randomElementSupplier) {
        return createSetOf(size, randomElementSupplier, HashSet::new);
    }

    public static final <T> Set<T> createSetOf(final int size,
            final Supplier<T> randomElementSupplier, final Supplier<Set<T>> setSupplier) {
        validateArgs(size, randomElementSupplier, setSupplier);

        final Set<T> set = setSupplier.get();
        for (int i = 0; i < size; i++) {
            set.add(randomElementSupplier.get());
        }
        return set;
    }


    public static final <T> Collection<T> createCollectionOf(final int size,
            final Supplier<T> randomElementSupplier) {
        return createCollectionOf(size, randomElementSupplier, ArrayList::new);
    }

    public static final <T> Collection<T> createCollectionOf(final int size,
            final Supplier<T> randomElementSupplier,
            final Supplier<Collection<T>> collectionSupplier) {
        validateArgs(size, randomElementSupplier, collectionSupplier);

        final Collection<T> collection = collectionSupplier.get();
        for (int i = 0; i < size; i++) {
            collection.add(randomElementSupplier.get());
        }
        return collection;
    }

    private static final void validateArgs(final int size, final Supplier<?>... suppliers) {
        ValidationUtil.requireNaturalNumber(size);
        for (final var supplier : suppliers) {
            Objects.requireNonNull(supplier);
        }
    }
}
