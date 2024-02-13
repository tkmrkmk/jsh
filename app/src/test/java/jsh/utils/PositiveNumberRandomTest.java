package jsh.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import jsh.utils.exceptions.NonPositiveNumberException;

public class PositiveNumberRandomTest {
    @Test
    void instantiation_getDefault() {
        PositiveNumberRandom.getDefault();
    }

    @Test
    void instantiation_withInjectedRandom() {
        assertThrows(NullPointerException.class, () -> PositiveNumberRandom.of(1, 1, null));
        assertThrows(NonPositiveNumberException.class, () -> PositiveNumberRandom.of(-1, -1, null));
        assertThrows(NonPositiveNumberException.class, () -> PositiveNumberRandom.of(-1, 0, null));
        assertThrows(NonPositiveNumberException.class, () -> PositiveNumberRandom.of(0, -1, null));

        Random r = ThreadLocalRandom.current();
        PositiveNumberRandom.of(1, 1, r);
        PositiveNumberRandom.of(1000, 4000, r);
        PositiveNumberRandom.of(100, 1000, r);
    }

    @Test
    void instantiation_withDefaultRandom() {
        assertThrows(NonPositiveNumberException.class, () -> PositiveNumberRandom.of(-1, -1));
        assertThrows(NonPositiveNumberException.class, () -> PositiveNumberRandom.of(-1, 0));
        assertThrows(NonPositiveNumberException.class, () -> PositiveNumberRandom.of(0, -1));
        PositiveNumberRandom.of(0, 0);

        assertThrows(IllegalArgumentException.class, () -> PositiveNumberRandom.of(1000, 999));

        PositiveNumberRandom.of(1000, 4000);
        PositiveNumberRandom.of(100, 1000);
    }

    @Test
    void usage_withoutVariation() {
        var r = PositiveNumberRandom.of(1000, 1000);
        for (int i = 0; i < 1000; i++) {
            assertEquals(1000, r.nextInt());
        }
    }

    @Test
    void usage_withVariation() {
        var r = PositiveNumberRandom.getDefault();
        for (int i = 0; i < 1000; i++) {
            int n = r.nextInt();
            assertTrue(n >= 0 && n <= 100);
        }
    }

    @Test
    void usage_withSameSeededRandom() {
        var r1 = new Random(0xabcdefL);
        var pr1 = PositiveNumberRandom.of(0, 100, r1);

        var r2 = new Random(0xabcdefL);
        var pr2 = PositiveNumberRandom.of(0, 100, r2);

        for (int i = 0; i < 1000; i++) {
            assertEquals(pr1.nextInt(), pr2.nextInt());
        }
    }
}
