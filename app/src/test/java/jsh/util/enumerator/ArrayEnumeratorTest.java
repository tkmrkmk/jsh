package jsh.util.enumerator;

import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import jsh.util.debugging.DebuggingUtil;

public class ArrayEnumeratorTest {

    private final Consumer<Enumeration<?>> printFunc = elem -> {
        DebuggingUtil.printObject(ee -> ee.index + ": " + ee.element, elem);
    };

    @Test
    void stream_test() {
        final String[] sourceArray = new String[] {"zero", "one", "two", "three", "four"};
        new ArrayEnumerator<>(sourceArray).stream().forEach(printFunc);
    }

    @Test
    void stream_against_empty_array() {
        final String[] emptyArray = new String[] {};
        new ArrayEnumerator<>(emptyArray).stream().forEach(printFunc);
    }

    @Test
    void multiple_times_stream_foreach() {
        final String[] sourceArray = new String[] {"zero", "one", "two", "three", "four"};
        System.out.println("First\n----");
        new ArrayEnumerator<>(sourceArray).stream().forEach(printFunc);
        System.out.println("\nSecond\n----");
        new ArrayEnumerator<>(sourceArray).stream().forEach(printFunc);
    }
}
