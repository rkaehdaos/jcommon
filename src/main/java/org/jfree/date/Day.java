package org.jfree.date;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public enum Day {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);
    public static final DateFormatSymbols
            DATE_FORMAT_SYMBOLS = new SimpleDateFormat("", Locale.US).getDateFormatSymbols();

    public final int index;

    Day(int index) { this.index = index; }

    public static Day fromInt(int dayIndex){
        for (Day day : Day.values()) {
            if(day.index==dayIndex)
                return day;
        }
        throw new IllegalArgumentException("invalid day index " + dayIndex);
    }
    public int toInt() { return index; }

    public static Day parse(String s) {
        s = s.trim();
        for (Day day : Day.values()) {
            if (day.matches(s)) return day;
        }
        try {
            return fromInt(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid day" + s);
        }
    }

    private boolean matches(String s) {
        return s.equalsIgnoreCase(toString()) ||
                s.equalsIgnoreCase(toShortString());
    }
    @Override
    public String toString() {
        return DATE_FORMAT_SYMBOLS.getWeekdays()[index - 1];
    }

    private String toShortString() {
        return DATE_FORMAT_SYMBOLS.getShortWeekdays()[index - 1];
    }
}
