package jsh.util.io;

import java.io.PrintStream;
import jsh.util.iterator.ArrayIterator;

public class PrintUtil {
    public static final PrintStream printStream = System.out;

    public static final void println() {
        printStream.println();
    }

    public static final void println(final Object object) {
        printStream.println(object);
    }

    public static final void println(
            final String separator, final Object... objects) {
        for (final var itr = new ArrayIterator<>(objects); itr.hasNext(); itr.next()) {
            printStream.append(itr.get().toString());
            if (!itr.isLast()) {
                printStream.append(separator);
            }
            printStream.flush();
        }
    }
}
