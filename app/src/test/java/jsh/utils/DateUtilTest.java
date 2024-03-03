package jsh.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class DateUtilTest {

    private void sep(final String name) {
        System.out.printf("---- %s ----%n", name);
    }

    @Test
    void create_date() {
        sep("createDate");
        final var d1 = DateUtil.createDate(1999, 12, 31);
        final var d2 = DateUtil.createDate(1999, 12, 31);
        assertEquals(d2, d1);
        assertEquals(d1.getClass(), Date.class);
        assertEquals(d2.getClass(), Date.class);
        System.out.println(d1);
        System.out.println(d2);
    }

    @Test
    void truncate_time() {
        System.out.println("---- truncateTime ----");
        final Date today = new Date();
        final Date truncated = DateUtil.truncateTime(today);
        System.out.println("today     : " + today.toString());
        System.out.println("truncated : " + truncated.toString());

        assertNotEquals(today, truncated);

        final LocalDateTime todayLdt = LocalDateTime.now();
        final LocalDateTime truncatedLdt = DateUtil.truncateTime(todayLdt);
        assertNotEquals(todayLdt, truncatedLdt);
        assertEquals(todayLdt.toLocalDate(), truncatedLdt.toLocalDate());
    }

    @Test
    void to_LocalDateTime() {
        System.out.println("---- toLocalDateTime ----");
        final var date = DateUtil.createDate(1999, 10, 29, 20, 59, 50);
        final var ldt1 = DateUtil.toLocalDateTime(date);
        final var ldt2 = LocalDateTime.of(1999, 10, 29, 20, 59, 50);
        System.out.println(ldt1);
        System.out.println(ldt2);
        assertEquals(ldt1, ldt2);
    }

    @Test
    void to_LocalTime() {
        System.out.println("---- toLocalTime ----");
        final var date = DateUtil.createDate(1999, 10, 29, 23, 59, 58, 570);
        final var lt1 = DateUtil.toLocalTime(date);
        final var lt2 = LocalTime.of(23, 59, 58, 570000);
        System.out.println(date);
        System.out.println(lt1);
        System.out.println(lt2);
        assertEquals(lt1, lt2);
    }
}
