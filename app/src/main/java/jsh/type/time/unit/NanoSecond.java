package jsh.type.time.unit;

import java.math.BigInteger;

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
        return this.value < o.value;
    }

    public boolean ge(final NanoSecond o) {
        return this.value <= o.value;
    }

    public NanoSecond subtract(final NanoSecond ns) {
        final long t = this.value;
        final long a = ns.value;

        //
        final BigInteger bi = new BigInteger(String.valueOf(t));
        bi.subtract(new BigInteger(String.valueOf(a)));
        if (bi.compareTo(new BigInteger(String.valueOf(Long.MIN_VALUE))) <= -1) {
            throw new ArithmeticException();
        }
        return new NanoSecond(t - a);
    }

    public NanoSecond add(final NanoSecond ns) {
        final long t = this.value;
        final long a = ns.value;

        // input validation
        final BigInteger bi = new BigInteger(String.valueOf(a));
        bi.add(new BigInteger(String.valueOf(t)));
        if (bi.compareTo(new BigInteger(String.valueOf(Long.MAX_VALUE))) >= 1) {
            throw new ArithmeticException();
        }

        return new NanoSecond(t + a);
    }

    @Override
    public int compareTo(final NanoSecond anotherNs) {
        final long t = this.value;
        final long a = anotherNs.value;
        return (t < a) ? -1 : ((t == a) ? 0 : 1);
    }
}
