package jsh.util.enumeration.enumerable;

import org.junit.jupiter.api.Test;
import jsh.util.TestingUtil;
import jsh.util.TestingUtil.TestTimeResult;

public class EnumerableArrayTest {
    @Test
    void foreach() {
        final String[] sourceArray = new String[] {"zero", "one", "two", "three"};
        final EnumerableArray<String> ea = new EnumerableArray<>(sourceArray);
        for (final var ee : ea) {
            new StringBuilder().append(ee.index).append(": ").append(ee.element);
        }
    }

    @Test
    void forI() {
        final String[] sourceArray = new String[] {"zero", "one", "two", "three"};
        for (int i = 0; i < sourceArray.length; ++i) {
            new StringBuilder().append(i).append(": ").append(sourceArray[i]);
        }
    }

    @Test
    void time() {
        final int times = 10000;
        final EnumerableArrayTest self = new EnumerableArrayTest();
        final var forEachResult = TestingUtil.timeMultipleTimesTotal(() -> self.foreach(), times);
        System.out.println(forEachResult);
        System.out.println();

        final var forIResult = TestingUtil.timeMultipleTimesTotal(() -> self.forI(), times);
        System.out.println(forIResult);
    }

    void p(final TestTimeResult r) {
        System.out.println(new StringBuilder() //
                .append("Start time  : ").append(String.format("%,d", r.startNs)) //
                .append("\nEnd time    : ").append(String.format("%,d", r.endNs)) //
                .append("\nElapsed time: ").append(String.format("%,d", r.elapsedNs)) //
                .append("\n"));
    }
}
