package jsh.util;

import java.util.Objects;
import jsh.type.time.unit.NanoSecond;

public class TestingUtil {
    private TestingUtil() {}

    public static final TestTimeResult time(final Runnable r) {
        Objects.requireNonNull(r);
        final NanoSecond startNs = new NanoSecond(System.nanoTime());
        r.run();
        final NanoSecond endNs = new NanoSecond(System.nanoTime());
        return new TestTimeResult(startNs, endNs);
    }

    public static final TestTimeResult timeMultipleTimesTotal(
            final Runnable r, final int times) {
        final NanoSecond startNs = new NanoSecond(System.nanoTime());
        for (int i = 0; i < times; ++i) {
            r.run();
        }
        final NanoSecond endNs = new NanoSecond(System.nanoTime());
        return new TestTimeResult(startNs, endNs);
    }

    /**
     * An object to wrap timing result.
     */
    public static final class TestTimeResult {
        public final NanoSecond startNs;
        public final NanoSecond endNs;
        public final NanoSecond elapsedNs;

        private TestTimeResult(final NanoSecond startNs, final NanoSecond endNs) {
            if (endNs.gt(startNs)) {
                throw new IllegalArgumentException("end time is earlier than start time");
            }
            this.startNs = startNs;
            this.endNs = endNs;
            this.elapsedNs = new NanoSecond(endNs.value() - startNs.value());
        }

        @Override
        public String toString() {
            return "Start time  : " + String.format("%,d%n", startNs.value())
                +  "End time    : " + String.format("%,d%n", endNs.value())
                +  "Elapsed time: " + String.format("%,d", elapsedNs.value());
        }
    }
}
