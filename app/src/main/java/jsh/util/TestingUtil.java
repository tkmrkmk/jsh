package jsh.util;

public class TestingUtil {
    private TestingUtil() {}

    public static final TestTimeResult time(final Runnable r) {
        final long startNs = System.nanoTime();
        r.run();
        final long endNs = System.nanoTime();
        return new TestTimeResult(startNs, endNs);
    }

    public static final TestTimeResult timeMultiple(final Runnable r, final int number) {
        final long startNs = System.nanoTime();
        for (int i = 0; i < number; ++i) {
            r.run();
        }
        final long endNs = System.nanoTime();
        return new TestTimeResult(startNs, endNs);
    }

    /**
     * An object to wrap timing result.
     */
    public static class TestTimeResult {
        public final long startNs;
        public final long endNs;
        public final long elapsedNs;

        private TestTimeResult(final long startNs, final long endNs) {
            if (endNs < startNs) {
                throw new IllegalArgumentException("end time is earlier than start time");
            }
            this.startNs = startNs;
            this.endNs = endNs;
            this.elapsedNs = endNs - startNs;
        }

        @Override
        public String toString() {
            return new StringBuilder() //
                    .append("Start time  : ").append(String.format("%,d", startNs)) //
                    .append("\nEnd time    : ").append(String.format("%,d", endNs)) //
                    .append("\nElapsed time: ").append(String.format("%,d", elapsedNs)) //
                    .toString();
        }
    }
}