package jsh.util.io;

import java.io.PrintStream;
import jsh.util.iterator.ArrayIterator;
import lombok.NonNull;

public class PrintUtil {
    @NonNull
    public static PrintStream printStream = System.out;

    public static void println() {
        printStream.println();
    }

    public static void println(final Object object) {
        printStream.println(object);
    }

    public static void println(final String separator, final Object... objects) {
        final StringBuilder sb = new StringBuilder();
        for (final ArrayIterator<Object> it = new ArrayIterator<>(objects); it.hasNext();) {
            sb.append(it.next());
            if (!it.isLast()) {
                sb.append(separator);
            }
        }
        println(sb.toString());
    }
}
