package jsh.util.point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    void testEquals() {
        final Point p1 = new Point(1, 2);
        final Point p2 = new Point(1, 2);
        final Point p3 = new Point(2, 3);
        final Point p4 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        final Point p5 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);

        assertEquals(p1, p2, "Points with same coordinates should be equal");
        assertNotEquals(p1, p3, "Points with different coordinates should not be equal");
        assertEquals(p4, p5, "Points with same coordinates should be equal");
    }
}
