package jsh.type.time.unit;

public class NanoSecond implements Comparable<NanoSecond> {
    private final long value;

    public NanoSecond(final long value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public long value() {
        return this.value;
    }

    public boolean lt(final NanoSecond o) {
        return this.value < o.value;
    }

    public boolean le(final NanoSecond o) {
        return this.value <= o.value;
    }

    public boolean gt(final NanoSecond o) {
        return this.value > o.value;
    }

    public boolean ge(final NanoSecond o) {
        return this.value >= o.value;
    }

    public NanoSecond subtract(final NanoSecond ns) {
        if (this.value < ns.value) {
            throw new ArithmeticException("Result would be negative");
        }
        return new NanoSecond(this.value - ns.value);
    }

    public NanoSecond add(final NanoSecond ns) {
        return new NanoSecond(Math.addExact(this.value, ns.value));
    }

    @Override
    public int compareTo(final NanoSecond anotherNs) {
        final long t = this.value;
        final long a = anotherNs.value;
        return (t < a) ? -1 : ((t == a) ? 0 : 1);
    }
}
