package jsh.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author zhu2qian1
 */
public class DateUtil {
    private DateUtil() {
    }

    public static final int DAY_MILLISECONDS = 86400000; // 24 * 60 * 60 * 1000

    public static final Date createDate(final int y, final int m, final int d) {
        final Calendar cal = Calendar.getInstance(Locale.JAPAN);
        cal.clear();
        cal.set(y, m, d);
        return cal.getTime();
    }

    public static final Date truncateTime(final Date date) {
        final long l = date.getTime();
        final long m = l % DAY_MILLISECONDS;
        return new Date(l - m);
    }

    public static final LocalDateTime truncateTime(final LocalDateTime date) {
        return LocalDateTime.of(date.getDayOfYear(), date.getMonthValue(), date.getDayOfMonth(), 0, 0, 0, 0);
    }

    /**
     * Calendar はゴミなので使わないほうがいいです.
     *
     * @param date the date to convert from.
     * @return the {@code Calendar} Object that represents the date.
     */
    public static final Calendar toCalendar(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static final LocalDate toLocalDate(final Date date) {
        final Calendar cal = toCalendar(date);
        return LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH));
    }

    public static final LocalDate toLocalDate(final LocalDateTime date) {
        return LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
    }

    public static final LocalTime toLocalTime(final Date date) {
        final Calendar cal = toCalendar(date);
        return LocalTime.of(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND) * 1000);
    }

    public static final LocalDateTime toLocalDateTime(final Date date) {
        final Calendar cal = toCalendar(date);
        return LocalDateTime.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND) * 1000);
    }
}
