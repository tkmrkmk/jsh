package jsh.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

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

    public static final Date createDate(final int year, final int month, final int day) {
        return createDate(year, month, day, 0, 0, 0, 0);
    }

    public static final Date createDate(final int year, final int month, final int day,
            final int hour, final int minute) {
        return createDate(year, month, day, hour, minute, 0, 0);
    }

    public static final Date createDate(final int year, final int month, final int day,
            final int hour, final int minute, final int second) {
        return createDate(year, month, day, hour, minute, second, 0);
    }

    public static final Date createDate(final int year, final int month, final int day,
            final int hour, final int minute, final int second, final int millisecond) {
        final Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, millisecond);
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
        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 0, 0);
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

    /**
     * Convert a {@code Date} instance into {@code LocalTime}.
     *
     * @param date a {@code Date} instance to convert.
     * @return a converted {@code LocalTime} instance.
     */
    public static final LocalTime toLocalTime(final Date date) {
        final Calendar cal = toCalendar(date);
        return LocalTime.of(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND) * 1000);
    }

    /**
     * Convert a {@code Date} instance into {@code LocalDateTime}.
     *
     * @param date a {@code Date} instance to convert.
     * @return a converted {@code LocalDateTime} instance.
     */
    public static final LocalDateTime toLocalDateTime(final Date date) {
        final Calendar cal = toCalendar(date);
        return LocalDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
                cal.get(Calendar.MILLISECOND) * 1000);
    }
}
