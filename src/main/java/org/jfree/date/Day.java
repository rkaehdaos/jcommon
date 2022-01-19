package org.jfree.date;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public enum Day {
    SUNDAY(Calendar.SUNDAY),
    MONDAY(Calendar.MONDAY),
    TUESDAY(Calendar.TUESDAY),
    WEDNESDAY(Calendar.WEDNESDAY),
    THURSDAY(Calendar.THURSDAY),
    FRIDAY(Calendar.FRIDAY),
    SATURDAY(Calendar.SATURDAY);

    private final int index;

    private static DateFormatSymbols dateFormatSymbols =
            new SimpleDateFormat("", Locale.US).getDateFormatSymbols();

    Day(int day) {
        this.index = day;
    }

    public static Day fromInt(int index) throws IllegalArgumentException {
        for (Day d : Day.values()) {
            if (d.index == index)
                return d;
        }
        throw new IllegalArgumentException(
                String.format("Illegal day index: %d", index)
        );
    }


    public static Day parse(String s) {
        s = s.trim();
        for (Day day : Day.values()) {
            if (day.matches(s)) return day;
        }

        throw new IllegalArgumentException(
                String.format("%s is not a valid weekday string", s)
        );

    }

    private boolean matches(String s) {
        return s.equalsIgnoreCase(toString()) ||
                s.equalsIgnoreCase(toShortString());
    }

    @Override
    public String toString() {
        return dateFormatSymbols.getWeekdays()[index];
    }

    private String toShortString() {
        return dateFormatSymbols.getShortWeekdays()[index];
    }

    public int toInt() {
        return index;
    }
}
