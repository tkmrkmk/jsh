package jsh.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class DateUtilTest {

    @Test
    void dateCreation() {
        final var d1 = DateUtil.createDate(1999, 12, 31);
        final var d2 = DateUtil.createDate(1999, 12, 31);
        assertEquals(d2, d1);
        assertEquals(d1.getClass(), Date.class);
        assertEquals(d2.getClass(), Date.class);
    }

    @Test
    void truncateTime() {
        final Date today = new Date();
        final Date different = DateUtil.truncateTime(today);
        assertNotEquals(today, different);
        final LocalDateTime todayLdt = LocalDateTime.now();
        final LocalDateTime diffLdt = DateUtil.truncateTime(todayLdt);
        assertNotEquals(todayLdt, diffLdt);
    }

    @Test
    void toLocalDateTime() {
        final var date = DateUtil.createDate(1999, 10, 29, 20, 59, 50);
        final var ldt1 = DateUtil.toLocalDateTime(date);
        final var ldt2 = LocalDateTime.of(1999, 10, 29, 20, 59, 50);
        assertEquals(ldt1, ldt2);
    }

    @Test
    void toLocalTime() {
        final var date = DateUtil.createDate(1999, 10, 29, 23, 59, 58, 570);
        final var lt1 = DateUtil.toLocalTime(date);
        final var lt2 = LocalTime.of(23, 59, 58, 570000);
        System.out.println(lt1);
        System.out.println(lt2);
    }
}
