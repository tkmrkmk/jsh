package jsh.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class DateUtilTest {

    @Test
    void dateCreation() {
        var d1 = DateUtil.createDate(1999, 12, 31);
        var d2 = DateUtil.createDate(1999, 12, 31);
        assertEquals(d2, d1);
        assertEquals(d1.getClass(), Date.class);
        assertEquals(d2.getClass(), Date.class);
    }

    @Test
    void truncateTime() {
        Date today = new Date();
        Date different = DateUtil.truncateTime(today);
        assertNotEquals(today, different);
        LocalDateTime todayLdt = LocalDateTime.now();
        LocalDateTime diffLdt = DateUtil.truncateTime(todayLdt);
        assertNotEquals(todayLdt, diffLdt);
    }
}
