package jsh.util.debugging;

import java.util.function.Function;

public class DebuggingUtil {
    private DebuggingUtil() {}

    /**
     * Does nothing. To use this method effectively, set a breakpoint on the line that says
     * "return;" and return to the caller so that you can inspect the situation in the debugger at
     * the moment.
     */
    public static void nop() {
        return;
    }

    /**
     * Converts an object into {@code String}. The intended use is implementing {@code toString}
     * from outside of the class.
     *
     * @param <T> the type of the object to convert
     * @param converter the provider of string-converting function
     * @param target the targeted object to be converted into string
     * @return the converted string of {@code target}
     */
    public static <T> String stringifyObject(final Function<T, String> converter, final T target) {
        return converter.apply(target);
    }

    public static <T> void printObject(final Function<T, String> converter, final T target) {
        System.out.println(stringifyObject(converter, target));
    }
}
