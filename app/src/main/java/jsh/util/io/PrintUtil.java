package jsh.util.io;

import java.io.PrintStream;
import jakarta.annotation.Nonnull;
import jsh.util.iterator.ArrayIterator;

public class PrintUtil {
    public static PrintStream printStream = System.out;

    public static final void println() {
        printStream.println();
    }

    public static final void println(final Object object) {
        printStream.println(object);
    }

    public static final void println(
            @Nonnull final String separator, @Nonnull final Object... objects) {
        final StringBuilder sb = new StringBuilder();
        for (final var itr = new ArrayIterator<Object>(objects); itr.hasNext();) {
            sb.append(itr.next());
            if (!itr.isLast()) {
                sb.append(separator);
            }
        }
        println(sb.toString());
    }
}
