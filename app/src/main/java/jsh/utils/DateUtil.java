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
public final class DateUtil {
    private DateUtil() {}

    /**
     * A day represented in milliseconds. Used to remove {@code Date}'s sub-date (hour, minutes,
     * etc.) information.
     */
    public static final int DAY_MILLISECONDS = 86400000; // 24 * 60 * 60 * 1000

    /**
     * Create date from given {@code y}, {@code m}, and {@code d}. <br/>
     * Note that the created {@code Date} instance does not have sub-date (hour, minutes, etc.)
     * information.
     *
     * @param y year
     * @param m month
     * @param d date
     * @return A {@code Date} instance that does not have sub-date information.
     */
    public static final Date createDate(final int y, final int m, final int d) {
        final Calendar cal = Calendar.getInstance(Locale.JAPAN);
        cal.clear();
        cal.set(y, m, d);
        return cal.getTime();
    }

    /**
     * Truncate sub-date (hour, minutes, etc.) information from {@code Date} instance and return it.
     *
     * @param date The {@code Date} instance to remove sub-date information from.
     * @return A {@code Date} instance without sub-date information.
     */
    public static final Date truncateTime(final Date date) {
        final long l = date.getTime();
        final long m = l % DAY_MILLISECONDS;
        return new Date(l - m);
    }

    /**
     * Truncate sub-date (hour, minutes, etc.) information from {@code LocalDateTime} instance and
     * return it.
     *
     * @param date The {@code LocalDateTime} instance to remove sub-date information from.
     * @return A {@code LocalDateTime} instance without sub-date information.
     */
    public static final LocalDateTime truncateTime(final LocalDateTime date) {
        return LocalDateTime.of(date.getDayOfYear(), date.getMonth(), date.getDayOfMonth(), 0, 0);
    }

    /**
     * Convert a {@code Date} instance into a {@code Calendar} instance.
     * 
     * @param date the {@code Date} instance to convert from.
     * @return a converted {@code Calendar} instance.
     */
    public static final Calendar toCalendar(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * Convert a {@code Date} instance into {@code LocalDate}.
     * 
     * @param date a {@code Date} instance to convert.
     * @return a converted {@code LocalDate} instance.
     */
    public static final LocalDate toLocalDate(final Date date) {
        final Calendar cal = toCalendar(date);
        return LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),
                cal.get(Calendar.DAY_OF_MONTH));
    }

    public static final LocalDate toLocalDate(final LocalDateTime date) {
        return date.toLocalDate();
    }

    public static final LocalTime toLocalTime(final Date date) {
        final Calendar cal = toCalendar(date);
        return LocalTime.of(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND) * 1000);
    }

    public static final LocalDateTime toLocalDateTime(final Date date) {
        final Calendar cal = toCalendar(date);
        return LocalDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND) * 1000);
    }
}
